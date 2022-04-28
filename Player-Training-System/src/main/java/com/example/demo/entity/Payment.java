package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="Bank")

public class Payment {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String method;
	private String card;
	private String cvv;
	private String amount;
	
	private Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		System.out.println(id);
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
		System.out.println(method);
	}
	
	
	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
		System.out.println(card);
	}
	
	
	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
		System.out.println(cvv);
	}
	
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
		System.out.println(amount);
	}

	

	@Override
	public String toString() {
		return "payment [id=" + id + "method=" + method+ "card=" + card + "cvv=" + cvv+"amount=" + amount+"]";
	}
		

}
