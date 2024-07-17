package com.prjct.seguridad.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.prjct.seguridad.service.UserDetailsServiceImpl;

public class JwtTokenFilter extends OncePerRequestFilter{

	private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
	
	@Autowired
	JwtProvider jwtProvider;
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String token = getToken(request);
			if(token != null && jwtProvider.validateToken(token)) {
				String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
				// TODO Auto-generated method stub
				UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("Fallo el método doFilterInternal");
		}
		filterChain.doFilter(request, response);
		
	}

	private String getToken(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String header = request.getHeader("Authorization");
		if(header != null && header.startsWith("Bearer")) {
			return header.replace("Bearer", "");
		}
		return null;
	}
}
