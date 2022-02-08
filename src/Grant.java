import java.util.Scanner;
/**Grant*/
public class Grant {
    public static void main(String[] args) {
        int fives = 0, threes = 0;
        double sum = 0;
        int[] scores = new int[20];
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            scores[i] = scanner.nextInt();
        }
        for (int i = 0; i < count; i++){
            sum += scores[i];
            if (scores[i] == 5){
                fives++;
            } else if (scores[i] == 3){
                threes++;
            }
        }
        if (threes > 0){
            System.out.println("None");
        } else if (fives == count){
            System.out.println("Named");
        } else if ( 4.5 <= (sum / count) ){
            System.out.println("High");
        } else if ( 4.5 >= (sum / count) ){
            System.out.println("Common");
        }
    }
}
