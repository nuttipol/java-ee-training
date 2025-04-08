package my.example.jpa.lab03;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name="tester")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper=true)
public class Tester extends Person {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
