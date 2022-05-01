public class NumericService {

    /*
    * На вход поступает список, в котором лежат структуры следующего вида:
    * {
    *   НАЗВАНИЕ_1: {
    *                   ДИАПАЗОН: [-1, 500.01],
    *                   ТИП: INT/DOUBLE/ARRAY,
    *                   КОЛИЧЕСТВО_ЦИФР: ЧИСЛО (INT), если type = int
    *                   МАССИВ_РАЗМЕР: > 0, (если array)
    *                   ТИП_ЭЛЕМЕНТОВ МАССИВА: INT/DOUBLE,
    *   },
    *
    *   field {
    *   name : "name"
    *   type : string / num
    *   details : {
    *       type: float / int
    *       range: [1, 2]
    *   }
    *  }
    *   ...
    * } + необходимое количество записей
    * По названию структуры мы вызываем соответствующий метод
    *
    *
    * {
    *   age: {
    *           range: [10, 35],
    *           type: int,
    *        },
    *   passport_code: {
    *           range: [0, MAX_NUMBER],
    *           type: int,
    *           digit_number: 8,
    *       },
    *   math_marks: {
    *           range: [1, 5],
    *           type: array,
    *           array_len: 10,
    *           array_item_type: int,
    *   }
    *   amount: 5;
    * }
    *
    * */

    public void getRandomData() {

    }

    public int getRandomInteger(int leftBound, int rightBound) {
        return (int)(Math.round(Math.random() * (rightBound - leftBound) + leftBound));
    }

    public double getRandomDouble(int leftBound, int rightBound) {
        return Math.random() * (rightBound - leftBound) + leftBound;
    }

    public int getRandomInteger(int numberOfDigits) {
        int answer = 0;
        int digitOrder = 1;
        for (int i = 0; i < numberOfDigits; i++) {
            answer += digitOrder * (Math.round(Math.random() * 9));
            digitOrder *= 10;
        }
        return answer;
    }


}
