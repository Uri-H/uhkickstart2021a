  import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        int count = 0;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int samples = Integer.parseInt(in.nextLine()); 
        String[] data = new String[samples*2];
        while (in.hasNextLine()) {
            data[count] = in.nextLine();
            count++;
          }
          in.close();
          int record = 1;
          int length = 0;
          int casecount=1;
          String a;
          for(int i=0;i<samples;i++) {
              length = Integer.parseInt(data[(i*2)]);
              
              System.out.print("Case #" + casecount + ": 1 ");
              for(int j=1;j<length;j++) {
              if(data[(i*2) + 1].charAt(j)>data[(i*2)+1].charAt(j-1)){ 
                  record++;
              }
              else record = 1;
              System.out.print(record + " ");
             }
             System.out.println();
             record = 1;
             casecount++;
              }
      }
    }

