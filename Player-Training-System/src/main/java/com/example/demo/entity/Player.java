package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="Exam_Subjects")

public class Player {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String subject;
	private String payment;
	
	private Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	

	@Override
	public String toString() {
		return "player [id=" + id + "subject=" + subject+ "date=" + payment+"]";
	}
		
	
}
