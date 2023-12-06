import java.io.*;
import java.util.*;

class Day6pt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        ArrayList<Long> times = new ArrayList<>();
        ArrayList<Long> dist = new ArrayList<>();

        String line = br.readLine();
        line = line.substring(line.indexOf(":")+1);
        line = line.strip();
        line = line.trim().replaceAll(" +", " ");
        System.out.println(line);

        String[] nums = line.split(" ");

        for(int j = 0; j < nums.length; j ++) {
            times.add(Long.parseLong(nums[j]));
        } 


        line = br.readLine();
        line = line.substring(line.indexOf(":")+1);
        line = line.strip();
        line = line.trim().replaceAll(" +", " ");

        nums = line.split(" ");

        for(int j = 0; j < nums.length; j ++) {
            dist.add(Long.parseLong(nums[j]));
        } 
        
        long ret = 1;

        for(int i = 0; i < times.size(); i++) {
            int totalPossibilities = 0;
            for(int j = 0; j < times.get(i); j ++) {
                long timeCharged = j;

                long totalDistMoved = (times.get(i) - timeCharged) * timeCharged;
                if(totalDistMoved > dist.get(i)) {
                    totalPossibilities ++;
                }
            }
            if(totalPossibilities != 0) {
                ret *= totalPossibilities;
            }
        }
        /*
        Time:       47986698
        Distance:   400121310111540
         */
        pw.println(ret);
        pw.close();
        br.close();
    }
}