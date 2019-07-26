package my.example.jpa.lab04;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import my.example.jpa.lab02.ParentId;

@Entity 
@Table(name="student_parent_age")
@Data
@ToString
@EqualsAndHashCode
public class StudentParentAge {

	@EmbeddedId
	private ParentId id;
	
	private Long age;
}
