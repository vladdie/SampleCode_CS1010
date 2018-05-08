package utility;

public class Term {
	
	private boolean positive;
	private double max;
	private double min;
	private double value;
	private String name;
	
	public Term(boolean positive, double max, double min, double value, String name) {
		super();
		this.positive = positive;
		this.max = max;
		this.min = min;
		this.value = value;
		this.name = name;
	}
	
	
	public boolean isPositive() {
		return positive;
	}
	public void setPositive(boolean positive) {
		this.positive = positive;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getScore(){
		double score = -1;
		if(this.isPositive()){
			score = (value-min)/(max-min);
			
		}else{
			score = 1-(value-min)/(max-min);
		}
		return score;
		
	}
	
	public double getUtility(double score){
		double utility =(Math.exp(score)-1)/(Math.E-1);
		return utility;
		
	}
	
	public void getValueFromUtility(double utility){
		//utility to score
		double score = Math.log(utility*(Math.E-1)+1);
		//score to value
		if(this.isPositive()){
			value = (max-min)*score+min;
		}else{
			value= (max-min)*(1-score)+min;
		}
		
	}

}
