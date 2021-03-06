package sampleQuestions;

/**
 * 
 * @author Fan
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example:
 * 
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * define empty string as valid palindrome.
 *
 */

public class Palindrome {
	
	public static boolean isPalindrome(String str){
		
		if(str.isEmpty())
			return true;
		
		String processedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		
		//reverse a string
		/*char[] temp = processedStr.toCharArray();
		for(int head = 0; head < temp.length; head++){
			if(head < temp.length - head -1){
				char c = temp[head];
				temp[head] = temp[temp.length - head -1];
				temp[temp.length - head -1] = c;
			}
		}
		
		String reversedStr = temp.toString();*/
		System.out.println(processedStr);
		
		int head = 0;
		int tail = processedStr.length() -1;
		while(head < tail){
			System.out.println("head="+processedStr.charAt(head)+", tail="+processedStr.charAt(tail));
			if(processedStr.charAt(head) != processedStr.charAt(tail)){
				return false;
			}
			head++;
			tail--;
		}
		return true;
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(isPalindrome("race a car")){
			System.out.println("this is a palindrome");
		}else{
			System.out.println("this is not a palindrome");
		}
	}	

}
