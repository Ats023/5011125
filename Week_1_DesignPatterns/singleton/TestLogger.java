// TestLogger.java
public class TestLogger {
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Test if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Both references point to the same instance.");
        } else {
            System.out.println("Different instances.");
        }

        // Log a message
        logger1.log("Singleton pattern is working!");
    }
}
