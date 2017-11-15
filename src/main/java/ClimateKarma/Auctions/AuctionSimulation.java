package ClimateKarma.Auctions;

import java.util.concurrent.TimeUnit;

public class AuctionSimulation {
    final static long shortDelay = 400;
    final static long longDelay = 2 * shortDelay;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("[ Simulating auction... ]");
        delay(longDelay);

        System.out.println("[ Generating an auction... ]");
        delay(shortDelay);
        System.out.println("[ Seller posting an offer... ]");
        delay(shortDelay);
        System.out.println("[ Auctioneer broadcasting the offer to bidders... ]");
        delay(shortDelay);
        System.out.println("[ Bidders posting their bids... ]");
        delay(shortDelay);
        System.out.println("[ Collecting bids... ]");
        delay(shortDelay);
        System.out.println("[ Choosing the winning bid... ]");
        delay(shortDelay);
        System.out.println("[ Calculating the payment... ]");
        delay(shortDelay);
        System.out.println("[ Announcing the results of the auction... ]");
        delay(shortDelay);
        System.out.println("[ Connecting the seller and the buyer (the winning bidder)... ]");
        delay(shortDelay);
        System.out.println("[ Transferring the assets... ]");
        delay(longDelay);
        System.out.println("[ Executing the payment... ]");
        delay(longDelay);

        System.out.println("[ Auction finished ]");
    }

    public static void delay(long delay) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(delay);
    }
}
