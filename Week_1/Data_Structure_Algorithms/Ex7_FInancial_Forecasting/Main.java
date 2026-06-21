public class Main {

    // Simple recursive compounding
    public static double predict(double val, double rate, int periods) {
        if (periods == 0) {
            return val;
        }
        return predict(val * (1 + rate), rate, periods - 1);
    }

    public static void main(String[] args) {
        double initial = 1000.0;
        double rate = 0.05; 
        int years = 10;

        double target = predict(initial, rate, years);
        System.out.println("Forecasted Value: " + target);
    }
}