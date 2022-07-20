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
        int B = (int)s.charAt(1);
        int Bukva = s.charAt(0);
        int C = -1;
        if (Bukva == 'A') C = 1;
        if (Bukva == 'B') C = 2;
        if (Bukva == 'C') C = 3;
        if (Bukva == 'D') C = 4;
        if (Bukva == 'E') C = 5;
        if (Bukva == 'F') C = 6;
        if (Bukva == 'G') C = 7;
        if (Bukva == 'H') C = 8;
        int[] A = new int[]{B,C};
        return A;
    }
    public static String A1(int Cifra1, int Cifra2){
        int B = Cifra1;
        String C = "";
        if (Cifra2 == 1) C = "A";
        if (Cifra2 == 2) C = "B";
        if (Cifra2 == 3) C = "C";
        if (Cifra2 == 4) C = "D";
        if (Cifra2 == 5) C = "E";
        if (Cifra2 == 6) C = "F";
        if (Cifra2 == 7) C = "G";
        if (Cifra2 == 8) C = "H";
        String A = String.valueOf(B)+C;
        return A;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "INPUT.TXT";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String Stroka = sc.nextLine();
        String[] podstroki = Stroka.split("-");

        int [][] doska = new int[8][8];
        int [][] possible_moves_sh = new int[][]{{-1,-2},{-2,-1},{-2, 1},{1,-2},{-1, 2},{2,-1},{1, 2},{2, 1}};

        int [][] nach_con_prav = new int[8][2];
        for (int i = 0; i < 8; i++){
                nach_con_prav[i][0] = H8(podstroki[0])[0];
                nach_con_prav[i][1] = H8(podstroki[0])[1];

        };
        for (int i = 0; i < 8 ; i++){
            for (int j = 0; j < 2; j++){
                nach_con_prav[i][j] = nach_con_prav[i][j] + possible_moves_sh[i][j];
                System.out.println(nach_con_prav[i][j]);
            }
        }
        int F = 0;


        FileWriter writerS = new FileWriter("OUTPUT.TXT", false);
        writerS.write(String.valueOf(F));
        writerS.flush();
    }
}
