package udp;
/*
 * Created by Oray Kurt
 * Date: 01-Jul-2020
 * Time: 15:34
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args){
		int port = 50002;
		UDPServer server = new UDPServer(port);
		UDPClient client = new UDPClient(port);


		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(client);
		executorService.submit(server);
	}
}
