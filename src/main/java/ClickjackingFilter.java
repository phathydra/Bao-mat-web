import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/*")
public class ClickjackingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // Không cần cài đặt gì trong phương thức init
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("X-Frame-Options", "DENY"); // hoặc "SAMEORIGIN" hoặc "ALLOW-FROM uri"
        chain.doFilter(req, res);
    }
    public void destroy() {
        // Không cần cài đặt gì trong phương thức destroy
    }
}