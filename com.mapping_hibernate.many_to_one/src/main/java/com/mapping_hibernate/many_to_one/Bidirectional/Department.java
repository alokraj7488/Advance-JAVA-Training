package com.mapping_hibernate.many_to_one.Bidirectional;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "bi_department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String deptName;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Student> students;
	
	public Department() {
		super();
	}
	
	public Department(String deptName) {
		super();
		this.deptName = deptName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", students=" + students + "]";
	}
}
