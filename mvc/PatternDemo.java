package mvc;

public class PatternDemo {
	
	   public static void main(String[] args) {

	      StudentDemo model  = retriveStudentFromDatabase();

	      ViewDemo view = new ViewDemo();

	      ControllerDemo controller = new ControllerDemo(model, view);

	      controller.updateView();

	      controller.setStudentName("John");

	      controller.updateView();
	   }

	   private static StudentDemo retriveStudentFromDatabase(){
		  StudentDemo student = new StudentDemo();
	      student.setName("Faye Yu");
	      student.setID("10");
	      return student;
	   }

}
