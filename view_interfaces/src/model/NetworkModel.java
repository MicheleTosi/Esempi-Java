package model;

import java.net.*;
import java.util.*;

public class NetworkModel {

    public List<NetworkInterface> getNetworkInterfaces() throws SocketException {
        return Collections.list(NetworkInterface.getNetworkInterfaces());
    }

    public String getInterfaceDetails(NetworkInterface netIf) throws SocketException {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(netIf.getName()).append("\n");
        sb.append("Display Name: ").append(netIf.getDisplayName()).append("\n");
        sb.append("MTU: ").append(netIf.getMTU()).append("\n");
        sb.append("Up: ").append(netIf.isUp()).append("\n");
        sb.append("Loopback: ").append(netIf.isLoopback()).append("\n");
        sb.append("Virtual: ").append(netIf.isVirtual()).append("\n");
        sb.append("Multicast: ").append(netIf.supportsMulticast()).append("\n");

        Enumeration<InetAddress> addresses = netIf.getInetAddresses();
        while (addresses.hasMoreElements()) {
            InetAddress addr = addresses.nextElement();
            sb.append("Indirizzo: ").append(addr.toString()).append("\n");
        }

        return sb.toString();
    }
}
