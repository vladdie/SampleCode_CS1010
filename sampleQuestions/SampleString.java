package sampleQuestions;

public class SampleString {
	
	String myString;
	
	//constructor using char[]
	public SampleString(char[] charaters) {
		super();
		myString = "";
		for(int i=0; i<charaters.length; i++){
			myString+=charaters[i];
		}
		// TODO Auto-generated constructor stub
	}
	
	//constructor using string
	public SampleString(String s) {
		myString = s;
		
	}
	
	public String reverse(){
		String reversedString = "";
		for(int i=myString.length()-1; i>=0; i--){
			reversedString += myString.charAt(i);
		}
		
		return reversedString;	
	}
	
	public void selfReverse(){
		char[] temp = myString.toCharArray();
		for(int i=0; i<temp.length; i++){
			if(i<temp.length-1-i){
				char c = temp[i];
				temp[i]=temp[temp.length-1-i];
				temp[temp.length-1-i] = c;
			}
			System.out.println(temp[i]);
		}
		
		myString = String.valueOf(temp);
		System.out.println(myString);
	}

	public static void main(String[] args){
		
		SampleString testStr = new SampleString("helloWorld");
		//System.out.println(testStr.reverse());
		testStr.selfReverse();
	}

}
