package my.example.jpa.lab04;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import my.example.jpa.lab03.Person;


@Entity 
@Table(name="student")
@Getter
@Setter
@ToString(exclude="computer")
@EqualsAndHashCode(callSuper=true)
public class Student extends Person {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne 
	@JoinColumn(name="locker_id")
	private Locker locker;
	 
	@OneToOne(cascade={CascadeType.ALL}) 
	@JoinColumn(name="labtop_id")
	private Labtop computer;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Mobile phone;
	 
}
