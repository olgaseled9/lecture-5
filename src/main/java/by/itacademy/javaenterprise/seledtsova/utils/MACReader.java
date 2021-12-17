package by.itacademy.javaenterprise.seledtsova.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MACReader {

    public static String getMacAddress() {
        InetAddress ip;
        NetworkInterface network;
        try {
            ip = InetAddress.getLocalHost();
            network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                stringBuilder.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return String.valueOf(stringBuilder);
        } catch (UnknownHostException | SocketException e) {
            return "UnknownMAC";
        }
    }
}
