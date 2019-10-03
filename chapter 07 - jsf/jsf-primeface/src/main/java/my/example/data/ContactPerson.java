package my.example.data;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContactPerson extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
