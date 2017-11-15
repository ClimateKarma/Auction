package ClimateKarma.Auctions;

import ClimateKarma.Payments.BiddingPrice;
import ClimateKarma.Payments.BiddingPriceWithId;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static ClimateKarma.Currencies.PaymentCurrencies.mBTC;

public class AuctionSimulation {
    private final static long SHORT_DELAY = 1500;
    private final static long LONG_DELAY = 2 * SHORT_DELAY;
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
        delay(SHORT_DELAY);
        System.out.println("[ Type of auction: Vickrey's Second Price ... ]");
        delay(LONG_DELAY);

        System.out.println("[ Seller posts an offer... ]");
        System.out.println("Auctioned item: " + auctionedItem);
        delay(SHORT_DELAY);
        System.out.println("[ Auction House broadcasts the offer to bidders... ]");
        delay(SHORT_DELAY);
        System.out.println("[ Bidders send their bids... ]");
        delay(SHORT_DELAY);
        getBidsFromConsole();
        System.out.println("[ Collecting bids... ]");
        displayBids(bids);
        delay(SHORT_DELAY);
        System.out.println("[ Choosing the winning bid... ]");
        winningBidder = chooseWinningBidder(bids);
        delay(LONG_DELAY);
        System.out.println("The winner is bidder #" + winningBidder + ".");
        delay(SHORT_DELAY);
        System.out.println("[ Calculating the payment... ]");
        payment = calculatePayment(bids);
        delay(LONG_DELAY);
        System.out.println("The payment will be " + payment + ".");
        delay(SHORT_DELAY);
        System.out.println("[ Announcing the results of the auction... ]");
        delay(SHORT_DELAY);
        System.out.println("[ Connecting the seller and the buyer (the winning bidder)... ]");
        delay(SHORT_DELAY);
        System.out.println("[ Transferring the assets... ]");
        delay(LONG_DELAY);
        System.out.println("[ Executing the payment... ]");
        delay(LONG_DELAY);

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
        int winningIndex = getHighestBidder(bids);
        return winningIndex;
    }

    private static BiddingPriceWithId[] sortBidsDecreasingly(BiddingPrice[] bids) {
        int numberOfBids = bids.length;
        BiddingPriceWithId[] bidsWithIndices = new BiddingPriceWithId[numberOfBids];
        for (int i = 0; i < numberOfBids; i++) {
            bidsWithIndices[i] = new BiddingPriceWithId(bids[i].getAmount(), i);
        }
        Arrays.sort(bidsWithIndices);
        ArrayUtils.reverse(bidsWithIndices);
        return bidsWithIndices;
    }

    private static int getHighestBidder(BiddingPrice[] bids) {
        BiddingPriceWithId[] sortedBidsWithIndices = sortBidsDecreasingly(bids);
        return sortedBidsWithIndices[0].idOfBidder;
    }

    private static Double get2ndHighestBid(BiddingPrice[] bids) {
        BiddingPriceWithId[] sortedBidsWithIndices = sortBidsDecreasingly(bids);
        int secondIndex = (bids.length > 1 ? 1 : 0);
        return sortedBidsWithIndices[secondIndex].priceValue;
    }

    private static void displayBids(BiddingPrice[] bids) throws InterruptedException {
        for (int i = 0; i < bids.length; i++) {
            System.out.println("Bid #" + (i+1) + ": " + bids[i]);
            delay(SHORT_DELAY);
        }
    }

    private static BiddingPrice calculatePayment(BiddingPrice[] bids) {
        Double bid = get2ndHighestBid(bids);
        return new BiddingPrice(bid, bids[0].getCurrency());
    }
}
