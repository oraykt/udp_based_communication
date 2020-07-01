package udp;
/*
 * Created by Oray Kurt
 * Date: 01-Jul-2020
 * Time: 15:41
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPClient implements Runnable{
	private final int port;

	public UDPClient(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		try(DatagramSocket clientSocket = new DatagramSocket(port)){
			int maxUdpPacketPayloadSize = 65507;

			byte[] buffer = new byte[maxUdpPacketPayloadSize];

			// It will throw a timeout exception and then close client.
			clientSocket.setSoTimeout(5000);
			while(true){
				DatagramPacket datagramPacket = new DatagramPacket(buffer,0,buffer.length);
				clientSocket.receive(datagramPacket);

				String receivedMessage = new String(datagramPacket.getData());

				System.out.println(receivedMessage);
			}
		} catch (SocketException e) {
			// TODO port is not found
			e.printStackTrace();
		} catch (IOException e) {
			// TODO enables client to not keep listening for a while.
			System.out.println("Timeout. Client is closing.");
		}

	}
}
