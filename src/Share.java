public class Share {
    private String ticker;
    private String name;
    private float price;

    public Share(String ticker, String name, float price) {
        this.ticker = ticker;
        this.name = name;
        this.price = price;
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
}
