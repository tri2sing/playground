package random;

import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * Created by samadhik on 11/1/16.
 */
public class IPAddr {
    public static void main(String[] args) {
        try {
            Inet4Address testIP = (Inet4Address) Inet4Address.getByName("192.168.0.1");
            System.out.println("testIP.toString = " + testIP.toString());
            System.out.println("testIP.getHostAddress = " + testIP.getHostAddress());
            testIP = (Inet4Address) Inet4Address.getByName("www.google.com");
            System.out.println("testIP.toString = " + testIP.toString());
            System.out.println("testIP.getHostAddress = " + testIP.getHostAddress());
            InetAddress [] testIPs = InetAddress.getAllByName("www.cnn.com");
            for (InetAddress ip : testIPs) {
                System.out.println("ip.toString = " + ip.toString());
                System.out.println("ip.getHostAddress() = " + ip.getHostAddress());
            }
           //testIP = (Inet4Address) Inet4Address.getByName("256.256.256.256");
        } catch (UnknownHostException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            e.printStackTrace();
        }
    }
}
