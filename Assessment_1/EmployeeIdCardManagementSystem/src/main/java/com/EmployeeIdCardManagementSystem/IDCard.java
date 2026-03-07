package com.EmployeeIdCardManagementSystem;

import java.awt.datatransfer.Transferable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class IDCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long cardNumber;
	private String issueDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", referencedColumnName = "id", unique = true)
	private Employee employee;

	public IDCard() {
		super();
	}

	public IDCard(long cardNumber, String issueDate, Employee employee) {
		super();
		this.cardNumber = cardNumber;
		this.issueDate = issueDate;
		this.employee = employee;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "IDCard [id=" + id + ", cardNumber=" + cardNumber + ", issueDate=" + issueDate + ", employee=" + employee
				+ "]";
	}

}
