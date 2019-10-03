package my.example.data;

import java.io.Serializable;

import lombok.Data;

@Data
public class Provice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String name;
}
