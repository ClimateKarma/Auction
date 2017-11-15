package ClimateKarma.Payments;

public class BiddingPriceWithId implements Comparable<BiddingPriceWithId> {
    public final Double priceValue;
    public final int IdOfBidder;

    public BiddingPriceWithId(double priceValue, int IdOfBidder) {
        this.priceValue = priceValue;
        this.IdOfBidder = IdOfBidder;
    }

    @Override
    public int compareTo(BiddingPriceWithId other) {
        return priceValue.compareTo(other.priceValue);
    }

    @Override
    public String toString() {
        return "bidder #" + IdOfBidder + " with bid " + priceValue;
    }
}
