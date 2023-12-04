import java.io.*;
import java.util.*;

class day4pt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int ret = 0;
        for(int i = 0; i < 208; i ++) {
            String line = br.readLine(); 
            // System.out.println(line);

            line = line.substring(line.indexOf(":")+1); // end inclusive, beginning exclusive
            line = line.strip();
            line = line.replace("  ", " ");
            // System.out.println(line);

            int currSum = 0;

            String winningNums = line.substring(0, line.indexOf("|")-1);
            String cardNums = line.substring(line.indexOf("|") + 2);

            String[] winArr = winningNums.split(" ");
            String[] cardArr = cardNums.split(" ");
            
            List winList = Arrays.asList(winArr);
            
            for(int j = 0; j < cardArr.length; j ++) {
                if(winList.contains(cardArr[j])) {
                    if(currSum == 0) currSum++;
                    else currSum *= 2;
                }
            }
            ret += currSum;
        }

        pw.println(ret);
        pw.close();
        br.close();
    }
}