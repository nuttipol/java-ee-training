package my.example.jpa.lab04;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import my.example.jpa.lab02.ParentId;


@Entity 
@Table(name="student_parent")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class StudentParent  {
	
	@EmbeddedId
	private ParentId id;
	
	private String name;
	
	@OneToOne(cascade={CascadeType.ALL}) 
	@PrimaryKeyJoinColumns({
		@PrimaryKeyJoinColumn(name="person_id", referencedColumnName="person_id"),    
		@PrimaryKeyJoinColumn(name="parent_type", referencedColumnName="parent_type") })
	private StudentParentAge parentAge;
}
