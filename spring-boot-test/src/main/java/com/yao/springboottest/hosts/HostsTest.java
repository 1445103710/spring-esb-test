package com.yao.springboottest.hosts;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.*;

/**
 * @className HostsTest
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/04/09 10:34
 */
@Slf4j
public class HostsTest {
    public static ArrayList<String> getLocalIpAddr()
    {
        ArrayList<String> ipList = new ArrayList<String>();
        InetAddress[] addrList;
        try
        {
            Enumeration interfaces= NetworkInterface.getNetworkInterfaces();
            while(interfaces.hasMoreElements())
            {
                NetworkInterface ni=(NetworkInterface)interfaces.nextElement();
                Enumeration ipAddrEnum = ni.getInetAddresses();
                while(ipAddrEnum.hasMoreElements())
                {
                    InetAddress addr = (InetAddress)ipAddrEnum.nextElement();
                    if (addr.isLoopbackAddress() == true)
                    {
                        continue;
                    }

                    String ip = addr.getHostAddress();
                    if (ip.indexOf(":") != -1)
                    {
                        //skip the IPv6 addr
                        continue;
                    }

                    log.debug("Interface: " + ni.getName()
                            + ", IP: " + ip);
                    ipList.add(ip);
                }
            }

            Collections.sort(ipList);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("Failed to get local ip list. " + e.getMessage());
            throw new RuntimeException("Failed to get local ip list");
        }

        return ipList;
    }

    public static void getLocalIpAddr(Set<String> set)
    {
        ArrayList<String> addrList = getLocalIpAddr();
        set.clear();
        for (String ip : addrList)
        {
            set.add(ip);
        }
    }
    /**
     * get local host
     * @return host
     */
    public static String getHost(){
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error(e.getMessage(),e);
        }
        return null;
    }

    public static void main(String args[])
    {
        //ArrayList<String> addrList = getLocalIpAddr();
        HashSet<String> addrSet = new HashSet<String>();
        getLocalIpAddr(addrSet);
        for (String ip : addrSet)
        {
            System.out.println("Local ip:" + ip);
        }
        System.out.println("#################");
        System.out.println("ip2："+getHost());
    }

}
