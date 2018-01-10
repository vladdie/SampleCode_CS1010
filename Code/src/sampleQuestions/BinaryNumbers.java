package sampleQuestions;

import java.util.Scanner;

public class BinaryNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        int decimal = scan.nextInt();
        int quotient = decimal;
        int reminder = 0;
        int counter = 0;
        int maxCounter = 0;
        while(quotient >0){
            reminder = quotient % 2;
            if(reminder == 1){
                counter ++;
                if(maxCounter < counter){
                	maxCounter = counter;
                }
            }else{
                counter = 0;
            }
            quotient = quotient / 2;
        }
        System.out.println(counter);
	}

}
