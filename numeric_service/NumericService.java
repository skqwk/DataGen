import java.util.ArrayList;
import java.util.List;

public class NumericService {

    private static final double MIN_DOUBLE = Double.MIN_VALUE;
    private static final double MAX_DOUBLE = Double.MAX_VALUE;
    private static final int MIN_INTEGER = Integer.MIN_VALUE;
    private static final int MAX_INTEGER = Integer.MIN_VALUE;


    public List<List<Number>> getRandomArrays(int numberOfArrays, int leftBound, int rightBound, int arrayLength, NumberType numberType) {
        List<List<Number>> randomArrays = new ArrayList<>();
        for (int i = 0; i < numberOfArrays; i++) {
            randomArrays.add(getRandomArray(leftBound, rightBound, arrayLength, numberType));
        }
        return randomArrays;
    }

    public List<Integer> getRandomIntegers(int numberOfIntegers, int leftBound, int rightBound) {
        List<Integer> randomIntegers = new ArrayList<>();
        for (int i = 0; i < numberOfIntegers; i++) {
            randomIntegers.add(getRandomInteger(leftBound, rightBound));
        }
        return randomIntegers;
    }

    public List<Double> getRandomDoubles(int numberOfDoubles, int leftBound, int rightBound) {
        List<Double> randomDoubles = new ArrayList<>();
        for (int i = 0; i < numberOfDoubles; i++) {
            randomDoubles.add(getRandomDouble(leftBound, rightBound));
        }
        return randomDoubles;
    }

    public List<Integer> getRandomIntegersFixedLength(int numberOfIntegers, int numberOfDigits) {
        List<Integer> randomIntegers = new ArrayList<>();
        for (int i = 0; i < numberOfIntegers; i++) {
            randomIntegers.add(getRandomIntegerFixedLength(numberOfDigits));
        }
        return randomIntegers;
    }

    public List<Number> getRandomArray(int leftBound, int rightBound, int arrayLength, NumberType numberType) {
        List<Number> array = new ArrayList<>(arrayLength);
        switch (numberType) {
            case INTEGER: {
                for (int i = 0; i < arrayLength; i++) {
                    array.add(getRandomInteger(leftBound, rightBound));
                }
                break;
            }
            case DOUBLE: {
                for (int i = 0; i < arrayLength; i++) {
                    array.add(getRandomDouble(leftBound, rightBound));
                }
                break;
            }
        }
        return array;
    }


    public int getRandomInteger(int leftBound, int rightBound) {
        return (int)(Math.round(Math.random() * (rightBound - leftBound) + leftBound));
    }

    public double getRandomDouble(int leftBound, int rightBound) {
        return Math.random() * (rightBound - leftBound) + leftBound;
    }

    public long getRandomDigit() {
        return (Math.round(Math.random() * 9));
    }

    public int getRandomIntegerFixedLength(int numberOfDigits) {
        int answer = 0;
        int digitOrder = 1;
        for (int i = 0; i < numberOfDigits; i++) {
            long digit = 0;
            if (i == numberOfDigits - 1) {
                while (digit == 0) {
                    digit = getRandomDigit();
                }
            } else {
                digit = getRandomDigit();
            }
            answer += digit * digitOrder;
            digitOrder *= 10;
        }
        return answer;
    }


}
