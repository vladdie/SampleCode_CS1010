package mvc;

public class ControllerDemo {
	   
	private StudentDemo model;
	private ViewDemo view;
	
    public ControllerDemo(StudentDemo model, ViewDemo view){
       this.model = model;
       this.view = view;
    }

    public void setStudentName(String name){
       model.setName(name);        
    }

    public String getStudentName(){
       return model.getName();        
    }

    public void setID(String rollNo){
        model.setID(rollNo);        
    }

    public String getID(){
       return model.getID();        
    }

    public void updateView(){                
       view.printStudentDetails(model.getName(), model.getID());
    }    
}
