import java.util.Map;
import java.util.TreeMap;

//решение должно содержать данный класс
class LabForKata{

    public static void main(String[] args) {
        LabForKata test = new LabForKata();
        System.out.println(test.calc("9 - 10"));
        System.out.println(test.calc("0 - 10"));
        System.out.println(test.calc("9 / 2"));
        System.out.println(test.calc("9 * 10"));
        System.out.println(test.calc("9 + 10"));
        System.out.println(test.calc("VI / III"));
        System.out.println(test.calc("VI * III"));
        System.out.println(test.calc("VI + III"));
        System.out.println(test.calc("VI - III"));
        System.out.println(test.calc("A - b"));
//        System.out.println(test.calc("I - II")); //error
//        System.out.println(test.calc("I + 1")); // error
//        System.out.println(test.calc("1 + 2 + 3")); /*need get error*/
//        System.out.println(test.calc("1"));
    }

    //Решение должно содержать данный метод
    public String calc(String inputString) {
        String[] array = inputString.split(" ");
        if (array.length > 4){
            throw new IllegalArgumentException("more than 2 elements");
        }
        boolean itsRomanNumbers = Roman.itsRomanNumbers(array);

        int firstValue = 0;
        int secondValue = 0;
        String operator = array[1];

        if (!itsRomanNumbers){
            firstValue = Integer.parseInt(array[0]);
            secondValue = Integer.parseInt(array[2]);
            if (firstValue > 10 || secondValue > 10){
                throw new IllegalArgumentException("One Of Values Bigger Than 10");
            }
            if (firstValue < 1 || secondValue < 1){
                throw new IllegalArgumentException("One Of Values Smaller Than 1");
            }
        }

        if (itsRomanNumbers){
            return calculateRoman(array);
        } else { return calculate(firstValue, secondValue, operator); }
    }

    private String calculate(int first, int second, String operator) {
        String result = "";
        switch (operator){
            case "/" : result = String.valueOf(first / second); break;
            case "*" : result = String.valueOf(first * second); break;
            case "-" : result = String.valueOf(first - second); break;
            case "+" : result = String.valueOf(first + second); break;
            default: throw new IllegalArgumentException("Invalid Operator");
        }
        return result;
    }

    private String calculateRoman(String[] array) {
        int firstValue = Roman.getRomanValue(array[0]);
        int secondValue = Roman.getRomanValue(array[2]);
        return Roman.intToRoman(Integer.parseInt(calculate(firstValue,secondValue,array[1])));
    }

    class Roman {
        private final static TreeMap<Integer, String> map = new TreeMap<>();
        static {
            map.put(1000, "M");
            map.put(900, "CM");
            map.put(500, "D");
            map.put(400, "CD");
            map.put(100, "C");
            map.put(90, "XC");
            map.put(50, "L");
            map.put(40, "XL");
            map.put(10, "X");
            map.put(9, "IX");
            map.put(8, "VIII");
            map.put(7, "VII");
            map.put(6, "VI");
            map.put(5, "V");
            map.put(4, "IV");
            map.put(3, "III");
            map.put(2, "II");
            map.put(1, "I");
        }

        // this method created
        public static boolean itsRomanNumbers(String[] string){
            return map.containsValue(string[0]) && map.containsValue(string[2]);
        }

        // this method created
        public static int getRomanValue(String s){
            for(Map.Entry<Integer,String> entry : map.entrySet()) {
                if (entry.getValue().equals(s)){
                    return entry.getKey();
                }
            }
            return 0;
        }

        public static String intToRoman(int num) {
            int l =  map.floorKey(num);
            if ( num == l ) {
                return map.get(num);
            }
            return map.get(l) + intToRoman(num - l );
        }

        public String intToRomanWithoutRecursion(int num) {
            StringBuilder sb = new StringBuilder();
            int l = map.floorKey(num);
            sb.append(map.get(l));

            while (num != l){
                int temp = map.floorKey(num - l);
                sb.append(map.get(temp));
                l += temp;
            }
            return sb.toString();
        }
    }
}

