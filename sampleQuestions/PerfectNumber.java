package sampleQuestions;
/**
 * 
 * @author Fan
 *
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 * Given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 *
 * Example: 
 * input = 28, 28=1+2+4+7+14 -->output = true
 */

public class PerfectNumber {
	
	public static boolean isPerfect(int num){
		
		if(num == 0 || num == 1){
			return false;
		}
		
		int divider = 1;
		int quotient = num;
		int sum = 0;
		
		while(divider < num){
			divider++;
			if(num % divider == 0){
				quotient = num / divider;
				if(divider > quotient)
					break;
				sum += quotient + divider;
			}
		}
			
			
		//plus 1
		sum += 1;
		if(num != sum)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(isPerfect(28)){
			System.out.println("this is a perfect number");
		}else{
			System.out.println("this is not a perfect number");
		}
	}

}
