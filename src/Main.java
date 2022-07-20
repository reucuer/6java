import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;
import java.lang.String;
import java.util.Arrays;



public class Main {
    public static int[] H8(String s){
        int B = Character.getNumericValue(s.charAt(1));
        int Bukva = s.charAt(0);
        int C = -1;
        if (Bukva == 'A') C = 1;
        else if (Bukva == 'B' || Bukva == 'b') C = 2;
        else if (Bukva == 'C' || Bukva == 'c') C = 3;
        else if (Bukva == 'D' || Bukva == 'd') C = 4;
        else if (Bukva == 'E' || Bukva == 'e') C = 5;
        else if (Bukva == 'F' || Bukva == 'f') C = 6;
        else if (Bukva == 'G' || Bukva == 'g') C = 7;
        else if (Bukva == 'H' || Bukva == 'h') C = 8;
        else C = 0;
        int[] A = new int[]{B,C};
        return A;
    }
    public static String A1(int Cifra1, int Cifra2){
        int B = Cifra1;
        String C = "";
        if (Cifra2 == 1) C = "A";
        else if (Cifra2 == 2) C = "B";
        else if (Cifra2 == 3) C = "C";
        else if (Cifra2 == 4) C = "D";
        else if (Cifra2 == 5) C = "E";
        else if (Cifra2 == 6) C = "F";
        else if (Cifra2 == 7) C = "G";
        else if (Cifra2 == 8) C = "H";
        else C = "T";

        String A = C+String.valueOf(B);

        return A;
    }
    public static boolean proverka_istina(String[] podstroki){
        boolean bool = false;
        boolean bool1 = false;
        boolean bool2 = false;
        boolean bool3 = false;
        if (podstroki.length == 2) {
            bool1 = true;
            if (H8(podstroki[0])[0] <= 8 && H8(podstroki[0])[0] > 0) bool2 = true;
            if (H8(podstroki[1])[0] <= 8 && H8(podstroki[1])[0] > 0) bool3 = true;
        }
        if (bool1 && bool2 && bool3) bool = true;
        return bool;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "INPUT.TXT";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String Stroka = sc.nextLine();
        String[] podstroki = Stroka.split("-");
        String answer = "ERROR";
        if (proverka_istina(podstroki)) {
            int[][] doska = new int[8][8];
            int[][] possible_moves_sh = new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {1, -2}, {-1, 2}, {2, -1}, {1, 2}, {2, 1}};

            int[][] nach_con_prav = new int[8][2];
            for (int i = 0; i < 8; i++) {
                nach_con_prav[i][0] = H8(podstroki[0])[1];
                nach_con_prav[i][1] = H8(podstroki[0])[0];

            }
            ;
            String BIT = "";
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 2; j++) {
                    nach_con_prav[i][j] = nach_con_prav[i][j] + possible_moves_sh[i][j];
                    //System.out.println(nach_con_prav[i][j]);
                }
                //System.out.println(nach_con_prav[i][0] + "_" + nach_con_prav[i][1]);
                System.out.println(A1(nach_con_prav[i][1], nach_con_prav[i][0]));
                if (A1(nach_con_prav[i][1], nach_con_prav[i][0]).equals(podstroki[1])) BIT = podstroki[1];
            }
            //int F = 0;
            if (!BIT.equals("")) answer = "YES";
            else if (BIT.equals("")) answer = "NO";
            else answer = "ERROR";
        }
        FileWriter writerS = new FileWriter("OUTPUT.TXT", false);
        writerS.write(String.valueOf(answer));
        writerS.flush();
    }
}
