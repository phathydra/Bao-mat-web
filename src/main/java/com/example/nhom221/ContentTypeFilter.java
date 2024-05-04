package com.example.nhom221;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class ContentTypeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Không cần thực hiện gì trong phương thức init() này
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Thiết lập header 'Content-Type'
        httpResponse.setContentType("text/html; charset=UTF-8");

        // Thiết lập header 'X-Content-Type-Options' để ngăn MIME-sniffing
        httpResponse.setHeader("X-Content-Type-Options", "nosniff");

        // Tiếp tục chuỗi filter
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Không cần thực hiện gì trong phương thức destroy() này
    }
}