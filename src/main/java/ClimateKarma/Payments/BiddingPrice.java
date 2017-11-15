package ClimateKarma.Payments;

import ClimateKarma.Currencies.PaymentCurrencies;

public class BiddingPrice {
    double amount;
    PaymentCurrencies currency;

    public BiddingPrice(double amount, PaymentCurrencies currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentCurrencies getCurrency() {
        return currency;
    }

    public void setCurrency(PaymentCurrencies currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency.toString();
    }
}
