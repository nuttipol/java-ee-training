package my.example.jpa.lab03;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity 
@Table(name="tester")
@Data
@ToString
@EqualsAndHashCode(callSuper=true)
public class Tester extends Person {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
