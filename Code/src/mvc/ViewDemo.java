package mvc;
/**
 * View of the sample model-student demo
 * 
 * View has few logic
 * 
 * @author Fan
 *
 */

public class ViewDemo {
	public void printStudentDetails(String studentName, String studentRollNo){
      System.out.println("Student: ");
      System.out.println("Name: " + studentName);
      System.out.println("Roll No: " + studentRollNo);
   }
}
