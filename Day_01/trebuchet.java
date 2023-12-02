import java.io.*;
import java.util.*;
class trebuchet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        long sum = 0;
        for(int i = 0; i < 1000; i ++) {
            String line = br.readLine();
            char num1 = '-';
            char num2 = '-';
            for(int j = 0; j < line.length(); j ++) {
                if(Character.isDigit(line.charAt(j))) {
                    if(num1 == '-') {
                        num1 = line.charAt(j);
                        num2 = line.charAt(j);
                    }
                    else {
                        num2 = line.charAt(j);
                    }
                }
            }
            String finalNum = "" + num1+num2;

            sum += Integer.parseInt(finalNum);
        }
        pw.println(sum);
        br.close();
        pw.close();
    }
}