public class SingletonTest {
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Check if both references point to the same instance
        System.out.println("Are both logger instances the same? " + (logger1 == logger2));

        // Log messages using the logger instance
        logger1.log("This is a log message from logger1.");
        logger2.log("This is a log message from logger2.");
    }
}
