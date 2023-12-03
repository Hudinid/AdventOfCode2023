import java.io.*;
import java.util.*;
class Day_03pt2 {
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        
        ArrayList<dataPoint> data = new ArrayList<dataPoint>();

        ArrayList<Point> specialChars = new ArrayList<Point>();

        for(int i = 0; i < 140; i ++) {
            String line = br.readLine(); 
            String builtNum = "";
            ArrayList<Point> pointsOfNums = new ArrayList<Point>();
            

            for(int j = 0; j < line.length(); j ++) {
                if(Character.isDigit(line.charAt(j))) {
                    builtNum += line.charAt(j);
                    pointsOfNums.add(new Point(i, j));
                }
                else {
                    if(!builtNum.equals("")) {
                        data.add(new dataPoint(Integer.parseInt(builtNum), pointsOfNums));
                        // System.out.println(pointsOfNums.size());

                        builtNum = "";
                        pointsOfNums.clear();
                    }
                    if(line.charAt(j) != '.' && line.charAt(j) == '*') {
                        specialChars.add(new Point(i, j));
                    }
                }
            }
            if(!builtNum.equals("")) {
                // System.out.println(builtNum);
                // System.out.println(pointsOfNums.size());
                data.add(new dataPoint(Integer.parseInt(builtNum), pointsOfNums));
            }
        }
        // }
        // // System.out.println(data[0][0]);
      
        int sum = 0;
        
        // for(int i = 0; i < 1; i ++) {
        //     data.get(i).printPoints();
        // }
        // for(int i = 0; i < specialChars.size(); i ++) {
        //     specialChars.get(i).printInfo();
        // }
        
        // for(int i = 0; i < data.size(); i ++) {
        //     dataPoint x = data.get(i);
            
        //     // System.out.println(x.number);
        //     boolean done = false;

        //     for(int j = 0; j < specialChars.size(); j++) {
        //         if(done) break;
        //         int connects = 0;
        //         for(int k = 0; k < x.points.size(); k++) {
        //             Point dataP = x.points.get(k);
        //             // dataP.printInfo();
        //             // specialChars.get(j).printInfo();
        //             if(dataP.comparePoints(specialChars.get(j))) {
        //                 // System.out.println("hi");
        //                 // sum += x.number;
        //                 // i--;
        //                 // System.out.println(x.number);
        //                 // data.remove(i);

        //                 // i--;
        //                 // done = true;
                        
        //                 // break;
        //             }
        //         }
        //     }
        System.out.println(specialChars.size());
        for(int i = 0; i < specialChars.size(); i ++) {
            Point x = specialChars.get(i);

            int numNear = 0;
            ArrayList<Integer> nums = new ArrayList<Integer>();
            ArrayList<dataPoint> tempData = new ArrayList<>(data);

            for(int j = 0; j < tempData.size(); j ++) {
                
                dataPoint y = tempData.get(j);
                
                for(int k = 0; k < y.points.size(); k ++) {
                    if(x.comparePoints(y.points.get(k))) {
                        // System.out.println("hi");
                        // System.out.println(y.number);
                        numNear ++;
                        nums.add(y.number);
                        tempData.remove(j);
                        j--;
                        break;
                    }
                }
            }
            // System.out.println("-----");
            if(numNear == 2) {
                sum += nums.get(0) * nums.get(1);
            }
        }

        

        pw.println(sum);

        br.close();
        pw.close();
    }
}


class dataPoint {
    int number;
    ArrayList<Point> points = new ArrayList<>();

    dataPoint(int number, ArrayList<Point> points)  {
        this.number = number;
        this.points = new ArrayList<Point>(points);
    }

    public void printPoints() {
        for(int i = 0; i < points.size(); i ++) {
            // System.out.println("Row: " + points.get(i).row);
            // System.out.println("Col: "  + points.get(i).col);
            // System.out.println("---");
            points.get(i).printInfo();
        }
    }
}

class Point {
    int row;
    int col;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void printInfo() {
        System.out.println("Row: " + this.row);
        System.out.println("Col: " + this.col);
        System.out.println("------");
    }

    public boolean comparePoints(Point otherPoint) {
        if(Math.abs(this.row-otherPoint.row) <= 1 && Math.abs(this.col - otherPoint.col) <= 1) { 
            return true;
        }
        return false;
    }
}