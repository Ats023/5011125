public class TestObserverPattern {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp1");
        Observer webApp = new WebApp("WebApp1");

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        stockMarket.setStockUpdate("AAPL is up by 2%");
        stockMarket.setStockUpdate("GOOG is down by 1%");

        stockMarket.deregister(mobileApp);
        stockMarket.setStockUpdate("TSLA is up by 5%");
    }
}
