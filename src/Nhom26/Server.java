package Nhom26;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
	public static int buffesize = Integer.MAX_VALUE;
    public static int port = 6000;

    public static void main(String [] args, Object soket){
        DatagramSocket socket;
        DatagramPacket dpsend, dpreceive;
        
        try {
            socket = new DatagramSocket(port);
            System.out.println("Wait for client");
            while (true)
            {
                dpreceive = new DatagramPacket(new byte[buffesize], buffesize);
                socket.receive(dpreceive);
                String temp = new String(dpreceive.getData(), 0, dpreceive.getLength());
                System.out.println("Client " + dpreceive.getAddress() + " via port number " + dpreceive.getPort());
         
                
                
                
                
                
            }

        }catch (Exception e){

        }
    }
}
