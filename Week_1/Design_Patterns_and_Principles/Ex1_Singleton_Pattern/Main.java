// Main.java
public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Initializing application...");
        logger2.log("Processing data...");

        System.out.println("Are both instances the same? " + (logger1 == logger2));
    }
}