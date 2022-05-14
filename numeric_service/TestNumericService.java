public class TestNumericService {

    public static void main(String[] args) {
        NumericService numericService = new NumericService();
        for (int i = -10; i < 0; i ++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(numericService.getRandomIntegerFixedLength(5));
            }
        }
    }

}
