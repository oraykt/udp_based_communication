package udp;
/*
 * Created by Oray Kurt
 * Date: 01-Jul-2020
 * Time: 15:34
 */

import java.io.IOException;
import java.net.*;

public class UDPServer implements Runnable{

	public final int clientPort;

	public UDPServer (int clientPort){
		this.clientPort = clientPort;
	}

	@Override
	public void run() {
		try(DatagramSocket serverSocket = new DatagramSocket(50005)){
			int i;
			for(i=0; i<10; i++){
				String message = "Message Number " +(i+1);
				DatagramPacket datagramPacket = new DatagramPacket(
						message.getBytes(),
						message.length(),
						InetAddress.getLocalHost(),
						clientPort
				);
				// Sending Packets
				serverSocket.send(datagramPacket);
			}
		}catch(SocketException e){
			// TODO The port number is used by another app
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO server doesn't know localHost url
			e.printStackTrace();
		} catch (IOException e) {
			// TODO server is not found
			e.printStackTrace();
		}
	}
}
