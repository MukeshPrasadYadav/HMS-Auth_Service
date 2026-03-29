package com.user.UserMicroservice.Auth;

import com.user.UserMicroservice.CustomizedUserDetails.CustomizedUserDetails;
import com.user.UserMicroservice.User.Entity.UserEntity;
import com.user.UserMicroservice.User.Repository.UserRepsitory;
import com.user.UserMicroservice.Utils.AuthUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JwtAuthFIlter extends OncePerRequestFilter {
    private  final AuthUtils authUtils;
    private  final  UserRepsitory userRepsitory;



    @Override
    protected  void  doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain  filterChain) throws IOException, ServletException{

        try{
            System.out.println("🔥 FILTER HIT: " + request.getRequestURI());
            String requestPath = request.getRequestURI();
            if(requestPath.startsWith("/auth/")){
                filterChain.doFilter(request,response);
                return;
            }
            String headerToken = request.getHeader("Authorization");
            if(headerToken == null || !headerToken.startsWith("Bearer")){
                filterChain.doFilter(request,response);
                return;
            }
            String accessToken =headerToken.split("Bearer ")[1];
            String userEmail = authUtils.getUserEmail(accessToken);

            if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserEntity user = userRepsitory.findByEmail(userEmail);
                CustomizedUserDetails userDetails = new CustomizedUserDetails(user);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

            filterChain.doFilter(request,response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
