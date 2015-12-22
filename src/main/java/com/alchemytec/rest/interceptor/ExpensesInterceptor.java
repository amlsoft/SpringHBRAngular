/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alchemytec.rest.interceptor;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
/**
 *
 * @author amalkan
 */
public class ExpensesInterceptor extends HandlerInterceptorAdapter {
 
    static final Logger logger = Logger.getLogger(ExpensesInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        
        boolean accessGranted = false;
        logger.info("Requested > " + request.getRequestURL().toString()
                + " at =" + System.currentTimeMillis());
        String token = request.getHeader("Authorization");
        if(token != null && !token.isEmpty()) {
            // Use access token to user details and grant authentication...  
            logger.info("access granted for token : " + token);
            accessGranted = true;
        }
        return accessGranted;
    }
 
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {}
 
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {}
}
