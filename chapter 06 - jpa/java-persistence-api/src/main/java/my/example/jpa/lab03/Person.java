package my.example.jpa.lab03;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
public class Person implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	protected Long id;

	@Column(name="name",length=100)
	protected String name;

	@Version
	@Column(name="version_id")
	protected long version;

}
