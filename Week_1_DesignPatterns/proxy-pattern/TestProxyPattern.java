// TestProxyPattern.java
public class TestProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.png");

        image1.display();
        image1.display();
        image2.display();
        image2.display();
    }
}
