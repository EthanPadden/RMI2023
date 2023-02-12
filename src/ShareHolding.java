public class ShareHolding {
    private String ticker;
    private String name;
    private float price;
    float numSharesOwned;

    public ShareHolding(String ticker, String name, float price, float numSharesOwned) {
        this.ticker = ticker;
        this.name = name;
        this.price = price;
        this.numSharesOwned = numSharesOwned;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getNumSharesOwned() {
        return numSharesOwned;
    }

    public void setNumSharesOwned(float numSharesOwned) {
        this.numSharesOwned = numSharesOwned;
    }
}
