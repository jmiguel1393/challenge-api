package cl.tenpo.challenge.api.util;

public class DataUtil {
    public static Integer calculateSum(Integer firstNumber, Integer secondNumber) {
        return firstNumber + secondNumber;
    }

    public static Double applyPercentage(Integer sum, Integer percentage) {
        return sum.doubleValue() * (1 + (percentage.doubleValue() / 100));
    }
}
