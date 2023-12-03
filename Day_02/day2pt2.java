
import java.util.*;
import java.io.*;

class day2pt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));



        int ret = 0;

        for(int i = 0; i < 100; i ++) {
            String line = br.readLine();
            line = line.substring(line.indexOf(":") + 2); // end inclusive, beginning exclusive
            String[] subsets = line.split(";");
            
            int minRed = 0;
            int minBlue = 0;
            int minGreen = 0;

            for(int j = 0; j < subsets.length; j ++) {
                String grab = subsets[j];
                String[] info = grab.split(", ");
                
                for(int k = 0; k < info.length; k ++) {
                    String[] lastInfo = info[k].strip().split(" "); 

                    // pw.println(lastInfo[1]);
                    // pw.println(lastInfo[0]);

                    if(lastInfo[1].strip().equals("red")) {
                        // pw.println(Integer.parseInt(lastInfo[0].strip()));
                        if(Integer.parseInt(lastInfo[0].strip()) > minRed) {
                            minRed = Integer.parseInt(lastInfo[0].strip());
                            
                        }
                    }

                    if(lastInfo[1].strip().equals("blue")) {
                        if(Integer.parseInt(lastInfo[0].strip()) > minBlue) {
                            minBlue = Integer.parseInt(lastInfo[0].strip());
                        }
                    }

                    if(lastInfo[1].strip().equals("green")) {
                        if(Integer.parseInt(lastInfo[0].strip()) > minGreen) {
                            minGreen = Integer.parseInt(lastInfo[0].strip());
                        }
                    }
                }

            }
            
            // pw.println("Red: " + minRed);
            // pw.println("Blue: " + minBlue);
            // pw.println("Green: " + minGreen);

            ret += minRed*minBlue*minGreen;
        }  

        pw.println(ret);
        br.close();
        pw.close();
    }
}