package utility;

public class Concession {
	
	private double landa = 0.1;
	
	public Concession(){
	}
	
	public void run(Term term, int round){
		//concession on price
		if(term.isPositive()){
			runPositive(term, round);
		}else{
			runNegative(term, round);
		}
	}
	
	private void runPositive(Term term,int round){
		
		performConcession(term,round);
		System.out.println("    "+term.getName()+": "+term.getValue());
		
	}
	
	
	private void runNegative(Term term,int round){
		
		performConcession(term,round);
		System.out.println("    "+term.getName()+": "+term.getValue());
	}
	
	
	private void performConcession(Term term, int round){
		double utility = term.getUtility(term.getScore());
		utility -= (round * landa)*utility; 
		term.getValueFromUtility(utility);
	}
	
	

}
