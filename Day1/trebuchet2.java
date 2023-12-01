import java.io.*;
import java.util.*;
class trebuchet2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        long sum = 0;
        for(int i = 0; i < 1000; i ++) {
            String line = br.readLine();
            char num1 = '-';
            char num2 = '-';
            for(int j = 0; j < line.length(); j ++) {
                // pw.println(j);
                // pw.println(line.indexOf("nine", j));
                if(Character.isDigit(line.charAt(j))) {
                    if(num1 == '-') {
                        num1 = line.charAt(j);
                        num2 = line.charAt(j);
                    }
                    else {
                        num2 = line.charAt(j);
                    }
                }
                else if(line.indexOf("one", j)-j == 0) {
                    if(num1 == '-') {
                        num1 = '1';
                        num2 = '1';
                    }
                    else {
                        num2 = '1';
                    }
                }
                else if (line.indexOf("two", j)-j == 0) {
                    if(num1 == '-') {
                        num1 = '2';
                        num2 = '2';
                    }
                    else {
                        num2 = '2';
                    }
                }
                else if (line.indexOf("three", j)-j == 0) {
                    if(num1 == '-') {
                        num1 = '3';
                        num2 = '3';
                    }
                    else {
                        num2 = '3';
                    }
                }
                else if (line.indexOf("four", j)-j == 0) {
                    if(num1 == '-') {
                        num1 = '4';
                        num2 = '4';
                    }
                    else {
                        num2 = '4';
                    }
                }
                else if (line.indexOf("five", j)-j == 0) {
                    if(num1 == '-') {
                        num1 = '5';
                        num2 = '5';
                    }
                    else {
                        num2 = '5';
                    }
                }
                else if (line.indexOf("six", j)-j == 0) {
                    if(num1 == '-') {
                        num1 = '6';
                        num2 = '6';
                    }
                    else {
                        num2 = '6';
                    }
                }
                else if (line.indexOf("seven", j)-j == 0) {
                    if(num1 == '-') {
                        num1 = '7';
                        num2 = '7';
                    }
                    else {
                        num2 = '7';
                    }
                }
                else if (line.indexOf("eight", j)-j == 0) {
                    if(num1 == '-') {
                        num1 = '8';
                        num2 = '8';
                    }
                    else {
                        num2 = '8';
                    }
                }
                else if (line.indexOf("nine", j)-j == 0) {
                    if(num1 == '-') {
                        num1 = '9';
                        num2 = '9';
                    }
                    else {
                        num2 = '9';
                    }
                }
            }
            String finalNum = "" + num1+num2;
            pw.println(finalNum);

            sum += Integer.parseInt(finalNum);
        }
        pw.println(sum);
        br.close();
        pw.close();
    }
}