import java.util.TreeMap;
/** Integer to Roman2 **/
class Roman2 {
    public static void main(String[] args) {
        System.out.println(new Roman2().intToRoman(1994));
        System.out.println(new Roman2().intToRomanWithoutRecursion(1994));
    }

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
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public String intToRoman(int num) {
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
