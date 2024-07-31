import java.util.ArrayList;
import java.util.List;

interface Stock {
    void register(Observer observer);
    void deregister(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockUpdate;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    public void setStockUpdate(String stockUpdate) {
        this.stockUpdate = stockUpdate;
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockUpdate);
        }
    }
}

interface Observer {
    void update(String stockUpdate);
}

class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockUpdate) {
        System.out.println(name + " received stock update: " + stockUpdate);
    }
}

class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockUpdate) {
        System.out.println(name + " received stock update: " + stockUpdate);
    }
}
