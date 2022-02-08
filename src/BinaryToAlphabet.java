import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** A. Числовые ребусы */
public class BinaryToAlphabet {
    static final Map<Integer, String> map = new HashMap<>();
    static {
        map.put(0,"a"); //0
        map.put(1,"b"); //1
        map.put(2,"c"); //4
        map.put(3,"d"); //8
        map.put(4,"e"); //16
        map.put(5,"f"); //32
        map.put(6,"g"); //64
        map.put(7,"h"); //128
        map.put(8,"i"); //256
        map.put(9,"j"); //512
        map.put(10,"k"); //1024...
        map.put(11,"l");
        map.put(12,"m");
        map.put(13,"n");
        map.put(14,"o");
        map.put(15,"p");
        map.put(16,"q");
        map.put(17,"r");
        map.put(18,"s");
        map.put(19,"t");
        map.put(20,"u");
        map.put(21,"v");
        map.put(22,"w");
        map.put(23,"x");
        map.put(24,"y");
        map.put(25,"z");
        map.put(26," ");
    }
    static int powerOfTwo(int number){
        for (int i = 0; i < 500; i++) {
            int powed = (int) Math.pow(2,i);
            if (powed == number){
                return i;
            }
        } return 0;
    }

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        int counter = 0;
        int getStringByPower;
        int[] array = new int[firstNum];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        //        int[] array = {4, 132, 148, 262292, 262164, 262420, 393492, 393476, 67502340, 67502336, 67502337, 68026625};

        for (int i = 0; i < array.length; i++) {
            if ( i > 1 && array[i] < counter){
                getStringByPower = powerOfTwo(  counter - array[i]);
            }else {
                getStringByPower = powerOfTwo(array[i] - counter);
            }
            result.append(map.get(getStringByPower));
            counter = counter + array[i] == 0 ? 1 : array[i];
        }
        System.out.println(result);

    }
}

//        int[] array = {1, 3, 2};
//        int[] array = {1, 2049, 2305, 2309, 2325};
//        int[] array = {4, 132, 148, 262292, 262164, 262420, 393492, 393476, 67502340, 67502336, 67502337, 68026625};
