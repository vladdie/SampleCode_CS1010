package sampleQuestions;

import java.util.Scanner;

public class SampleInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String str = scan.nextLine();
			System.out.println(str);
		}
		
		
		scan.close();
	}

}
