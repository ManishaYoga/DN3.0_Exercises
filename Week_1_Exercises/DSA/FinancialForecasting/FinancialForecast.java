public class FinancialForecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double initialValue, double growthRate, int periods) {
        // Base case: if no periods left, return the initial value
        if (periods == 0) {
            return initialValue;
        }
        // Recursive case: calculate future value for the remaining periods
        return calculateFutureValue(initialValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0; // Initial value
        double growthRate = 0.05; // 5% growth rate per period
        int periods = 10; // Number of periods

        double futureValue = calculateFutureValue(initialValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}
