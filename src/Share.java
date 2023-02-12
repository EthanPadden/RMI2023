public class Share {
    // TODO: change this and shareholding to interfaces
    private String name;
    private int numSharesAvailable;
    private float price;
    private long timeLeftUntilNextUpdate;

    public Share(String name, int numSharesAvailable, float price, long timeLeftUntilNextUpdate) {
        this.name = name;
        this.numSharesAvailable = numSharesAvailable;
        this.price = price;
        this.timeLeftUntilNextUpdate = timeLeftUntilNextUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumSharesAvailable() {
        return numSharesAvailable;
    }

    public void setNumSharesAvailable(int numSharesAvailable) {
        this.numSharesAvailable = numSharesAvailable;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getTimeLeftUntilNextUpdate() {
        return timeLeftUntilNextUpdate;
    }

    public void setTimeLeftUntilNextUpdate(long timeLeftUntilNextUpdate) {
        this.timeLeftUntilNextUpdate = timeLeftUntilNextUpdate;
    }
}
