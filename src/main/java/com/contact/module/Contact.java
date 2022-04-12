package com.contact.module;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table
@NamedQuery(name = "Contact.findAll", query = "SELECT h FROM Contact h")
public class Contact {
	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String phNo;

	@Column(name = "created_date")
	@CreationTimestamp
	private LocalDate CreatedDate;

	@Column(name = "updated_date")
	@UpdateTimestamp
	private LocalDate updateDate;
	
	private String status;
	
	
}
