package studentCalculator;

public class Student {
	
	private int studentId;
	private String name;
	private int marks1;
	private int marks2;
	private int marks3;
	public Student(int studentId, String name, int marks1, int marks2, int marks3) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
	}
	public int getStudentId() {
		return studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMarks1() {
		return marks1;
	}
	
	public int getMarks2() {
		return marks2;
	}
	
	public int getMarks3() {
		return marks3;
	}
	

}
