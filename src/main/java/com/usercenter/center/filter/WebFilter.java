package com.usercenter.center.filter;

/*
 *@author  fyy
 *@version 1.0
 *@time    2024-03-2010:56
 *@project Center
 */

import jakarta.servlet.*;

import java.io.IOException;

public class WebFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {

    }

    @Override
    public void destroy()
    {
        Filter.super.destroy();
    }
}
