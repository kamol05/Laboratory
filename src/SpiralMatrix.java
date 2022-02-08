import java.util.ArrayList;
import java.util.List;
/** Spiral Matrix*/
public class SpiralMatrix {
    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(
                new int[][]{ {1, 2, 3},
                             {4, 5, 6},
                             {7, 8, 9} } ));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int w = 0;
        int x = matrix.length-1;
        int y = 0;
        int z = matrix[0].length-1;
        while(w <= x && y <= z){
            for (int i = w; i <= z; i++) {
                list.add(matrix[w][i]);
            }
            for (int i = w+1; i <= x; i++) {
                list.add(matrix[i][z]);
            }
            if(w+1 <= x){
                for (int i = z-1; i >= y; i--) {
                    list.add(matrix[x][i]);
                }
            }
            if(y+1 <= z){
                for (int i = x-1; i > w; i--) {
                    list.add(matrix[i][y]);
                }
            }
            w++;
            x--;
            y++;
            z--;
        }
        return list;
    }
}
