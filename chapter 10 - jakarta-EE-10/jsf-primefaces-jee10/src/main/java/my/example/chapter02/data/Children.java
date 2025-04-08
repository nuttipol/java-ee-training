package my.example.chapter02.data;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Children extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
