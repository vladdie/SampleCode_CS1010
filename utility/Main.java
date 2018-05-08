package utility;

import java.util.ArrayList;

/**
 * price: negative for client, positive for server
 * volume: negative for server, positive for client
 * @author Fan
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Term priceClient = new Term(false, 50, 10, 10, "price");
		Term volumeClient = new Term(true, 15, 3, 15, "volume");
		ArrayList<Term> termsClient = new ArrayList<Term>();
		termsClient.add(priceClient);
		termsClient.add(volumeClient);
		Participant client = new Participant(termsClient,"client");
		
		
		Term priceServer = new Term(true, 80, 30, 80, "price");
		Term volumeServer = new Term(false, 10, 1, 1, "volume");
		ArrayList<Term> termsServer = new ArrayList<Term>();
		termsServer.add(priceServer);
		termsServer.add(volumeServer);
		Participant server = new Participant(termsServer, "server");
		
		client.runStrategy();
		System.out.println("\n************************************************");
		server.runStrategy();

	}

}
