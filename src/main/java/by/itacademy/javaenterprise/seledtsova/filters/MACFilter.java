package by.itacademy.javaenterprise.seledtsova.filters;

import by.itacademy.javaenterprise.seledtsova.utils.MACReader;
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
public class MACFilter extends HttpFilter {
    private static final Logger logger = LoggerFactory.getLogger(MACFilter.class);
    private final List<String> blackListMAC = new ArrayList<>();

    {
        blackListMAC.add("00:21:57:00:1f:02");
        blackListMAC.add("00:22:57:00:1f:02");
        blackListMAC.add("00:23:57:00:1f:02");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        logger.info("MAC Filter started");
        if (blackListMAC.contains(MACReader.getMacAddress())) {
            req.getRequestDispatcher("error.jsp").forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
        logger.info("MAC Filter finished");
    }
}

