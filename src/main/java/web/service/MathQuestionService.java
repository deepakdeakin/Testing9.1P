package web.service;

public class MathQuestionService {

    /**
     * Calculate Q1 result.
     *
     * @param number1
     * @param number2
     * @return
     */
    public static Double q1Addition(String number1, String number2) {
        if (!isNumeric(number1) || !isNumeric(number2)) {
            return null;
        }
        double result = Double.valueOf(number1) + Double.valueOf(number2);
        return result;
    }

    /**
     * Calculate Q2 result.
     *
     * @param number1
     * @param number2
     * @return
     */
    public static Double q2Subtraction(String number1, String number2) {
        if (!isNumeric(number1) || !isNumeric(number2)) {
            return null;
        }
        double result = Double.valueOf(number1) - Double.valueOf(number2);
        return result;
    }

    /**
     * Calculate Q3 result.
     *
     * @param number1
     * @param number2
     * @return
     */
    public static Double q3Multiplication(String number1, String number2) {
        if (!isNumeric(number1) || !isNumeric(number2)) {
            return null;
        }
        double result = Double.valueOf(number1) * Double.valueOf(number2);
        return result;
    }

    // Method to check if a string is numeric
    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}