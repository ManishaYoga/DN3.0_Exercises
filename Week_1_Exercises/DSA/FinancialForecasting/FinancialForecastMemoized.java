import java.util.HashMap;

public class FinancialForecastMemoized {

    private static HashMap<Integer, Double> memo = new HashMap<>();

    // Recursive method to calculate future value with memoization
    public static double calculateFutureValue(double initialValue, double growthRate, int periods) {
        // Check if the value is already computed
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }
        
        // Base case: if no periods left, return the initial value
        if (periods == 0) {
            return initialValue;
        }

        // Recursive case: calculate future value for the remaining periods
        double result = calculateFutureValue(initialValue * (1 + growthRate), growthRate, periods - 1);
        memo.put(periods, result);
        return result;
    }

    public static void main(String[] args) {
        double initialValue = 1000.0; // Initial value
        double growthRate = 0.05; // 5% growth rate per period
        int periods = 10; // Number of periods

        double futureValue = calculateFutureValue(initialValue, growthRate, periods);
        System.out.println("Future Value with Memoization: " + futureValue);
    }
}
