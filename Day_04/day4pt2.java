import java.io.*;
import java.util.*;

class day4pt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int ret = 0;
        
        HashMap<Integer, Long> cards = new HashMap<Integer, Long>();

        for(int i = 0; i < 208; i ++) {
            String line = br.readLine(); 
            // System.out.println(line);

            line = line.substring(line.indexOf(":")+1); // end inclusive, beginning exclusive
            line = line.strip();
            line = line.replace("  ", " ");
            // System.out.println(line);
            int numMultiply = 0;
            if(cards.containsKey(i)) {
                cards.put(i, (long)cards.get(i) + 1);
                numMultiply += cards.get(i);
            }
            else {
                cards.put(i, (long)1);
                numMultiply = 1;
            }

            int numMatch = 0;

            String winningNums = line.substring(0, line.indexOf("|")-1);
            String cardNums = line.substring(line.indexOf("|") + 2);

            String[] winArr = winningNums.split(" ");
            String[] cardArr = cardNums.split(" ");
            
            List winList = Arrays.asList(winArr);
            
            for(int j = 0; j < cardArr.length; j ++) {
                if(winList.contains(cardArr[j])) {
                    numMatch ++;

                    int cardValue = i + numMatch;
                        
                    if(cards.containsKey(cardValue)){
                        cards.put(cardValue, cards.get(cardValue) + 1 * numMultiply);
                    }

                    else {
                        cards.put(cardValue, (long)1 * numMultiply);
                    }

                }
            }
            
        }

        for(int key : cards.keySet()) {
            ret += cards.get(key);
            // System.out.println("Card Value: " + key);
            // System.out.println("Num Cards: " + cards.get(key));
            // System.out.println("-----");
        }

        pw.println(ret);
        pw.close();
        br.close();
    }
}
