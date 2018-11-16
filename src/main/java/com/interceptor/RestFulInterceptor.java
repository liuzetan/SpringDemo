package com.interceptor;

import com.bean.TokenBean;
import com.dao.TokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class RestFulInterceptor implements HandlerInterceptor {


    @Autowired
    private TokenDao tokenDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = request.getRequestURI();
        Map<String, String> headerMaps = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            headerMaps.put(key, value);
        }
        TokenBean tokenBean = tokenDao.isTokenAvailable(headerMaps.get("phone"));
        if (tokenBean != null && tokenBean.getToken().equals(headerMaps.get("token"))) {
            return true;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println(httpServletRequest.getRequestURI().toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
