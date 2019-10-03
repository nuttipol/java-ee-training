package my.example.data;

import java.io.Serializable;

import lombok.Data;

@Data
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String houseNo;
	private String street;
	private Provice province;
}
