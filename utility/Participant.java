package utility;

import java.util.ArrayList;

public class Participant {

	//private Term price;
	//private Term volume;
	private ArrayList<Term> terms;
	private String name;
	private Concession concession;
	
	public Participant(ArrayList<Term> terms,String name) {
		super();
		
		//this.price = price;
		//this.volume = volume;
		this.terms = terms;
		
		this.name = name;
		this.concession = new Concession();
	}
	
	
	public void runStrategy(){
		
		int k = 0;
		for(int i = 0; i<terms.size();i++){
			Term term = terms.get(i);
			
			if(!term.isPositive()){
				k = 0;
				do{
					System.out.println(name+" propose "+term.getName()+ " for round "+k);
					concession.run(term,k);
					k++;
				}while(term.getValue()<term.getMax());
				
				System.out.println(name+ term.getName() +" deadline reached! current value is "+term.getValue()+
						", range is "+"["+term.getMin()+", "+term.getMax()+"]");
			}else{
				k = 0;
				do{
					System.out.println(name+" propose "+term.getName()+ " for round "+k);
					concession.run(term,k);
					k++;
				}while(term.getValue()>term.getMin());
				System.out.println(name+ term.getName() +" deadline reached! current value is "+term.getValue()+
						", range is "+"["+term.getMin()+", "+term.getMax()+"]");
			}
		}
		
		
	
		
		
	}
	
	
	
}
