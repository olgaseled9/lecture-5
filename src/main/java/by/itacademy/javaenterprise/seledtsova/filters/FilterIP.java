package by.itacademy.javaenterprise.seledtsova.filters;

import by.itacademy.javaenterprise.seledtsova.utils.IPReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = "/*")
public class FilterIP extends HttpFilter {

    private static final Logger logger = LoggerFactory.getLogger(FilterIP.class);

    private final List<String> blockedListIP = new ArrayList<>();

    {
        blockedListIP.add("192.168.100.4");
        blockedListIP.add("192.168.100.89");
        blockedListIP.add("192.168.100.11");
        blockedListIP.add("192.168.100.12");
        blockedListIP.add("192.168.100.13");
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("IP filter started!");
        String ipAddress = IPReader.getIP(request);
        if (blockedListIP.contains(ipAddress)) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
        logger.info("IP filter finished!");
    }
}

