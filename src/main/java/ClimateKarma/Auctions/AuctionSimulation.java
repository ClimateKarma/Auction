package ClimateKarma.Auctions;

import ClimateKarma.Payments.BiddingPrice;
import ClimateKarma.Payments.BiddingPriceWithId;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static ClimateKarma.Currencies.PaymentCurrencies.mBTC;

public class AuctionSimulation {
    final static long shortDelay = 100;
    final static long longDelay = 3 * shortDelay;
    private static String auctionedItem = "80 Climate Drops, 50 Solar Coins, 100 Climate Coins";

    private static final BiddingPrice[] DEFAULT_BIDS = new BiddingPrice[]{
            new BiddingPrice(1, mBTC),
            new BiddingPrice(0.5, mBTC),
            new BiddingPrice(2, mBTC),
    };
    private static BiddingPrice[] bids = DEFAULT_BIDS;
    private static int winningBidder;
    private static BiddingPrice payment;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("[ Starting auction ... ]");
        delay(shortDelay);
        System.out.println("[ Type of auction: Vickrey's Second Price ... ]");
        delay(longDelay);

        System.out.println("[ Seller posts an offer... ]");
        System.out.println("Auctioned item: " + auctionedItem);
        delay(shortDelay);
        System.out.println("[ Auction House broadcasts the offer to bidders... ]");
        delay(shortDelay);
        System.out.println("[ Bidders send their bids... ]");
        delay(shortDelay);
        getBidsFromConsole();
        System.out.println("[ Collecting bids... ]");
        displayBids(bids);
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

    public static void delay(long delay) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(delay);
    }

    public static void getBidsFromConsole() {
        // TODO
/*        Scanner consoleInput = new Scanner(System.in);
        for (int i = 0; i < bids.length; i++) {
            System.out.println("Bid #" + (i+1) + ": ");
            bids[i] = consoleInput.nextLine();
        }*/
    }

    private static int chooseWinningBidder(BiddingPrice[] bids) throws InterruptedException {
        int winningIndex = get1stLargest(bids);
//        displayBids(bids);
        return winningIndex;
    }

    private static int get1stLargest(BiddingPrice[] bids) {
        BiddingPriceWithId[] bidsWithIndices = new BiddingPriceWithId[bids.length];
        for (int i = 0; i < bids.length; i++) {
            bidsWithIndices[i] = new BiddingPriceWithId(bids[i].getAmount(), i);
        }
//        Arrays.sort(bidsWithIndices, (p1, p2) -> p1.getKey().compareTo(p2.getKey()));
        Arrays.sort(bidsWithIndices);
        ArrayUtils.reverse(bidsWithIndices);
        System.out.println(bidsWithIndices[0]);
        System.out.println(bidsWithIndices[1]);
        System.out.println(bidsWithIndices[2]);
        return 2;
    }

    private static void displayBids(BiddingPrice[] bids) throws InterruptedException {
        for (int i = 0; i < bids.length; i++) {
            System.out.println("Bid #" + (i+1) + ": " + bids[i]);
            delay(shortDelay);
        }
    }

    private static BiddingPrice calculatePayment(BiddingPrice[] bids) {
        return bids[0];
    }
}
