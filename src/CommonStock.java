import java.text.NumberFormat;

public class CommonStock extends Security implements Valuation, Comparable<Security>{
    private int shares;
    private double purchasePrice;
    private double currentPrice;

    public CommonStock(String isin, String issuer, int shares, double purchasePrice, double currentPrice) {
        super(isin, issuer);
        this.shares = shares;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return "CommonStock [" +
                isin + ", " +
                issuer + ", " +
                "Purchase: " + currency.format(purchasePrice) + ", " +
                "Current: " + currency.format(currentPrice) + ", " +
                "Shares: " + shares + "]";
    }
    @Override
    public double percentReturn(){
        return (currentPrice-purchasePrice) / purchasePrice * 100.0;
    }
    @Override
    public double totalReturn(){
        return (currentPrice - purchasePrice) * shares;
    }

    @Override
    public int compareTo(Security other) {
        int issuerDiff = this.issuer.compareTo(other.issuer);
        if (issuerDiff != 0)
            return issuerDiff;
        if (other instanceof CommonStock) {
            CommonStock otherStock = (CommonStock) other;
            int currentPriceDiff = Double.compare(this.currentPrice, otherStock.currentPrice);
            if (currentPriceDiff != 0)
                return currentPriceDiff;
            int sharesDiff = this.shares - otherStock.shares;
            if (sharesDiff != 0)
                return sharesDiff;
            int purchasePriceDiff = Double.compare(this.purchasePrice, otherStock.purchasePrice);
            if (purchasePriceDiff != 0)
                return purchasePriceDiff;
        }
        return this.isin.compareTo(other.isin);
    }
}
