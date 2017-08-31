package random;

import java.util.Arrays;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        String [][] array = new String[][]{
                {"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}
        };
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
            for(int j = 0; j < array[i].length; j++){
                System.out.println("\t" + array[i][j]);
            }

        }
    }
}
