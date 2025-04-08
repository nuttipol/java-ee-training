package my.example.jpa.lab03;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name="programmer")
@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class Programmer extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
