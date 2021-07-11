import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        int count = 0;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int samples = Integer.parseInt(in.nextLine()); 
        String[][] dataA = new String[samples*3][3];
        System.out.print("hi");
        while (in.hasNextLine()&&count<=samples*3) {
            String a = in.nextLine();
            String[] splitData = a.split("\\s+");
            for(int j=0;j<3;j++) {
                if((count)%3==1&&j==1) dataA[count][j] = "0";
                else if((count)%3==2&&j==2) dataA[count][j] = splitData[j-1];
                else dataA[count][j] = splitData[j];
	        	System.out.print(dataA[count][j]);
	        	}
                System.out.println();
	        count++;
          }
          in.close();
          int[][] data= new int[samples*3][3];
	      for(int i=0;i<samples*3;i++) {
	    	  for(int j=0;j<3;j++) {
	    		  data[i][j]=Integer.parseInt(dataA[i][j]);
	    	  }
	      }
          int min = data[0][0];
          int max = data[0][0];
          //find the smallest number and largest number. test all of the inbetween ones 
          for(int i=0;i<samples*3;i++){
              for(int j=0;j<3;j++){
                  if(data[i][j]<min) min = data[i][j];
                  else if(data[i][j]>max) max = data[i][j];
              }
          }
          Integer[] maxProg = new Integer[samples];
          for(int i=0;i<samples;i++){
          maxProg[i]=0;
          }
          int ap = 0;
          for(int a=1;a<samples*3;a+=3){
                  for(int b=min;b<=max;b++){
                      data[a][1] = b;
                      for(int i=a-1;i<a+2;i++){
                      if(data[i][0]-data[i][1]==data[i][1]-data[i][2]) ap++;
                      
                      }
                      for(int i=0;i<3;i++){
                      if(data[a-1][i]-data[a][i]==data[a][i]-data[a+1][i]) ap++;
                      }
                      if(data[a-1][0]-data[a][1]==data[a][1]-data[a+1][2]) ap++;
                      if(data[a-1][2]-data[a][1]==data[a][1]-data[a+1][0]) ap++;
                  //check the square
                  if(maxProg[(a-1)/3]<ap) maxProg[(a-1)/3]=ap;
                  ap=0;
              }
          }
          for(int i=0;i<samples;i++) {
          System.out.print("Case #" + i + ": 1 " + maxProg[i]);
          System.out.println();
          }
          
      }
    }
