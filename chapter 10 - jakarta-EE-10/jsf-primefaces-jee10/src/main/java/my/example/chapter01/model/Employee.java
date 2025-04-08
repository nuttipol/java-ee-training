package my.example.chapter01.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_EMPLOYEE")
@EqualsAndHashCode(of="id")
public class Employee {
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "BIRTH_DATE")
	private LocalDate  birthDate;
	
	@Transient
	private String age;
	
	@Transient
	private int years;
	
	private Attachment images = new Attachment();
	
	private Attachment pdfs = new  Attachment();
	
	public Employee() {
		id = UUID.randomUUID().toString();
	}
	  
	public String getAge() {
		if (birthDate == null) {
			return "";
		}
		Period period = Period.between(birthDate, LocalDate.now());
		this.setYears(period.getYears());
		return String.format( "%d years %d months and %d days." , period.getYears(), period.getMonths(), period.getDays());  
	}
}
