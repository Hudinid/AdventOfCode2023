
import java.util.*;
import java.io.*;

class day2pt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int maxRed = 12;
        int maxGreen = 13;
        int maxBlue = 14;

        int ret = 0;

        for(int i = 0; i < 100; i ++) {
            boolean possible = true;
            String line = br.readLine();
            line = line.substring(line.indexOf(":") + 2); // end inclusive, beginning exclusive
            String[] subsets = line.split(";");
            

            for(int j = 0; j < subsets.length; j ++) {
                String grab = subsets[j];
                String[] info = grab.split(", ");
                
                for(int k = 0; k < info.length; k ++) {
                    String[] lastInfo = info[k].strip().split(" "); 

                    
                    if(lastInfo[1].strip().equals("red")) {
                        if(Integer.parseInt(lastInfo[0].strip()) > maxRed) {
                            possible = false;
                            break;
                        }
                    }

                    if(lastInfo[1].strip().equals("blue")) {
                        if(Integer.parseInt(lastInfo[0].strip()) > maxBlue) {
                            possible = false;
                            break;
                        }
                    }

                    if(lastInfo[1].strip().equals("green")) {
                        if(Integer.parseInt(lastInfo[0].strip()) > maxGreen) {
                            possible = false;
                            break;
                        }
                    }
                }

                if(!possible) {
                    break;
                }
            }
            if(possible) {
                pw.println(i+1);
                ret += i + 1;
            }
        }

        pw.println(ret);
        br.close();
        pw.close();
    }
}