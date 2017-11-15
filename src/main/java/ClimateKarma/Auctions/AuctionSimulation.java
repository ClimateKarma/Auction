package ClimateKarma.Auctions;

import java.util.concurrent.TimeUnit;

public class AuctionSimulation {
    // TODO final static long shortDelay = 400;
    final static long shortDelay = 100;
    final static long longDelay = 2 * shortDelay;
    private static String auctionedItem = "80 Climate Drops, 50 Solar Coins, 100 Climate Coins";
    private static String[] bids = new String[]{"1 mBTC", "0.5 mBTC", "2 mBTC"};
    private static int winningBidder;
    private static String payment = bids[0];

    public static void main(String[] args) throws InterruptedException {
//        TODO Scanner consoleInput = new Scanner(System.in);

        System.out.println("[ Starting auction ... ]");
        delay(shortDelay);
        System.out.println("[ Type of auction: Vickrey's Second Price ... ]");
        delay(longDelay);

//        System.out.println("[ Generating an auction... ]");
//        delay(shortDelay);
        System.out.println("[ Seller posts an offer... ]");
        System.out.println("Auctioned item: " + auctionedItem);
        delay(shortDelay);
        System.out.println("[ Auction House broadcasts the offer to bidders... ]");
        delay(shortDelay);
        System.out.println("[ Bidders send their bids... ]");
        delay(shortDelay);
/*        for (int i = 0; i < bids.length; i++) {
            System.out.println("Bid #" + (i+1) + ": ");
            bids[i] = consoleInput.nextLine();
        }*/
        System.out.println("[ Collecting bids... ]");
        for (int i = 0; i < bids.length; i++) {
            System.out.println("Bid #" + (i+1) + ": " + bids[i]);
            delay(shortDelay);
        }
        delay(shortDelay);
        System.out.println("[ Choosing the winning bid... ]");
        winningBidder = chooseWinningBidder(bids);
        delay(longDelay);
        System.out.println("The winner is bidder #" + winningBidder + ".");
        delay(shortDelay);
        System.out.println("[ Calculating the payment... ]");
        payment = calculatePayment(bids);
        delay(longDelay);
        System.out.println("The payment will be " + payment + ".");
        delay(shortDelay);
        System.out.println("[ Announcing the results of the auction... ]");
        delay(shortDelay);
        System.out.println("[ Connecting the seller and the buyer (the winning bidder)... ]");
        delay(shortDelay);
        System.out.println("[ Transferring the assets... ]");
        delay(longDelay);
        System.out.println("[ Executing the payment... ]");
        delay(longDelay);

        System.out.println("[ Closing the auction... ]");
    }

    private static int chooseWinningBidder(String[] bids) {
        return 2;
    }

    private static String calculatePayment(String[] bids) {
        return bids[0];
    }

    public static void delay(long delay) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(delay);
    }
}
