package by.itacademy.javaenterprise.seledtsova.utils;

import javax.servlet.http.HttpServletRequest;

public class IPReader {

    public static String getIP(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        } else {
            ipAddress = ipAddress.split(";")[0];
        }

        return ipAddress;
    }
}
