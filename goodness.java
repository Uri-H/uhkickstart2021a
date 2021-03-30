import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.*; 
import java.util.*; 
import java.util.ArrayList;
import java.lang.Math; 

public class goodness {
	public static void main(String[] args) {
	    int count = 0;
		int max = 0;
		int samples;
		String[][] goodness= new String[0][0];
		String rc;
		int rows;
		int cols;
	    try {
	      File myObj = new File("goodness1.txt");
	      Scanner myReader = new Scanner(myObj);
	      samples = Integer.parseInt(myReader.nextLine());
	      //int pizzas = Character.getNumericValue(firstLine.charAt(0));
	      System.out.println(samples);
	      
	      rc = myReader.nextLine();
	      String[] rcData = rc.split("\\s+");
	      rows=Integer.parseInt(rcData[0]);
	      cols=Integer.parseInt(rcData[1]);
	      goodness = new String[rows][cols];
	      while (myReader.hasNextLine()&&count<rows) {
	        String data = myReader.nextLine();
	        String[] splitData = data.split("\\s+");
	        
	        for(int j=0;j<splitData.length;j++) {
	        	goodness[count][j] = splitData[j];
	        	System.out.print(goodness[count][j]);
	        //}
	      }
	        System.out.println();
	        count++;
	      }
	      int[][] lshape= new int[rows][cols];
	      for(int i=0;i<rows-1;i++) {
	    	  for(int j=0;j<cols-1;j++) {
	    		  lshape[i][j]=Integer.parseInt(goodness[i][j]);
	    	  }
	      }
	      boolean check = true;
	      int lcount=0;
	      int colsegs=2;
	      int colsquare;
	      for(int i=0;i<rows-1;i++) {
	    	  for(int j=0;j<cols-1;j++) {
	    		  colsquare=j+1;
	    		  
	    		  while(lshape[i][colsquare]==1) {
	    			  for(int k=0;k<colsegs*2;k++) {
	    				  if(k+i<rows) {
	    			  if(lshape[k+i][j+1]!=1) check=false;
	    				  }
	    			  }
	    			  if(check==true) lcount++;
	    			  check = true;
	    			  colsquare++;
	    			  colsegs++;
	    			  System.out.println(lcount);
	    		  }
	    		  colsegs=2;
	    		  if(lshape[i+1][j]==1) {
	    			  max++;
	    		  }
	    	  }
	      } 
	      
	      
	      
	      
	      myReader.close();
	    }
	      catch (FileNotFoundException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		      }
	}

}
