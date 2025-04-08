package my.example.jpa.lab04;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import my.example.jpa.lab02.ParentId;

@Entity 
@Table(name="student_parent_age")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class StudentParentAge {

	@EmbeddedId
	private ParentId id;
	
	private Long age;
}
