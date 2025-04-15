package my.example.chapter04.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Country implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private String name;
}
