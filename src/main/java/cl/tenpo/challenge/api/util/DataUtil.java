package cl.tenpo.challenge.api.util;

public class DataUtil {
    public static Integer calculateSum(Integer firstNumber, Integer secondNumber) {
        return firstNumber + secondNumber;
    }

    public static Double applyPercentage(Integer sum, Integer percentage) {
        Double sumWithPercentage = sum.doubleValue() * (1 + (percentage.doubleValue() / 100));
        return roundToTwoDecimalPlaces(sumWithPercentage);
    }

    private static Double roundToTwoDecimalPlaces(Double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
