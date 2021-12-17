package by.itacademy.javaenterprise.seledtsova.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/second")
public class FilterContentType extends HttpFilter {

    static final Logger logger = LoggerFactory.getLogger(FilterContentType.class);

    private static final String ALLOWED_TYPE_OF_TEXT = "text/plain";
    private static final String REQUESTED_HEADER = "content-type";

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("Content-type filter started!");
        String contentType = request.getHeader(REQUESTED_HEADER);
        if (ALLOWED_TYPE_OF_TEXT.equals(contentType)) {
            chain.doFilter(request, response);
        } else {
            response.getWriter().write("Text plain only!");
        }
        logger.info("Content-type Filter finished");
    }
}

