package sampleQuestions;

/***
 * Calculate the hourglass sum for every hourglass in , 
 * then print the maximum hourglass sum.
 */

import java.util.Scanner;

public class TwoDemensionArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        
        int maxHourGlass = -100;
 
        for(int i=0; i <= 3; i++){
            for(int j=0; j <= 3; j++){
            	int currentHourGlass = 0;
            	currentHourGlass += arr[i][j]+arr[i][j+1]+arr[i][j+2]
            						+arr[i+1][j+1]
            					    +arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
            	if(currentHourGlass>maxHourGlass){
            		maxHourGlass = currentHourGlass;
            	}
            }
        }
        System.out.println(maxHourGlass);
	}

}
