public class FinancialForecasting {
    public static double calculateFutureValue(double initialValue, double growthRate, int periods) {
        // Base case: If no periods left, return the initial value
        if (periods == 0) {
            return initialValue;
        }
        // Recursive case: Calculate future value based on previous period's value
        return calculateFutureValue(initialValue, growthRate, periods - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double[] initialValue = {1000.0, 995.5, 999.0};  // Initial investment amount
        double[] growthRate = {0.05, 0.07, 0.095};      // Growth rate (5%)
        int[] periods = {10, 6, 11};              // Number of periods (years, months, etc.)

        double futureValue1 = calculateFutureValue(initialValue[0], growthRate[0], periods[0]);
        System.out.printf("Future Value given %d periods %.2f%n initial value %.2f%n growthRate: %.2f%n", periods[0], initialValue[0], growthRate[0], futureValue1);

        double futureValue2 = calculateFutureValue(initialValue[1], growthRate[1], periods[1]);
        System.out.printf("Future Value given %d periods %.2f%n initial value %.2f%n growthRate: %.2f%n", periods[1], initialValue[1], growthRate[1], futureValue2);

        double futureValue3 = calculateFutureValue(initialValue[2], growthRate[2], periods[2]);
        System.out.printf("Future Value given %d periods %.2f%n initial value %.2f%n growthRate: %.2f%n", periods[2], initialValue[2], growthRate[2], futureValue3);
    }
}
