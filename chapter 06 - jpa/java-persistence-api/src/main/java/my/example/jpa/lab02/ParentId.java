package my.example.jpa.lab02;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
public class ParentId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="person_id")
	private int personId;
	
	@Embedded
	private ParentType parentType;
	
}
