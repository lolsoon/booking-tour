package com.example.bookingTour.authentication;

import com.example.bookingTour.entity.User;
import com.example.bookingTour.service.IUserService;
import com.example.bookingTour.service.JWTTokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	
	private IUserService userService;
	
    public JWTAuthenticationFilter(String url, AuthenticationManager authManager, IUserService userService) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
        this.userService = userService;
    }

    @Override
    public Authentication attemptAuthentication(
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    		throws AuthenticationException, IOException, ServletException {
        
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                		request.getParameter("username"),
                		request.getParameter("password"),
                        Collections.emptyList()
                )
        );
    }

    @Override
    protected void successfulAuthentication(
    		HttpServletRequest request, 
    		HttpServletResponse response, 
    		FilterChain chain, 
    		Authentication authResult) throws IOException, ServletException {
    	// infor user
    	User user = userService.findUserByUserName(authResult.getName());
    	
        JWTTokenService.addJWTTokenAndUserInfoToBody(response, user);
    }
}
