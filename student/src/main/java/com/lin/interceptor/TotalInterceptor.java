package com.lin.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TotalInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
        String position = (String) request.getSession().getAttribute("position");
        if (position == null) {
            response.sendRedirect(request.getContextPath() + "/login");
             return false;
        }else {
            return true;
        }
    }
}


