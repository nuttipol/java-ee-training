package my.example.jpa.lab07;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString(exclude="cabinet")
@EqualsAndHashCode(of="id")
@Table(name="cabinet_assign",uniqueConstraints={
	    @UniqueConstraint(columnNames = {"cabinet_id", "user_id"})}) 
public class CabinetUser {
	
	public CabinetUser() {
		
	}
	
	public CabinetUser(Cabinet cabinet,User user,List<Privilege> privileges) {
		this.cabinet= cabinet;
		this.user= user;
		this.privileges= privileges;
	}

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="cabinet_assign_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cabinet_id",nullable=false)
	private Cabinet cabinet;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinTable(name="cabinet_assign_privilege",
		joinColumns={@JoinColumn(name="cabinet_assign_id")},
		inverseJoinColumns={@JoinColumn(name="privilege_id")})
    private List<Privilege> privileges;
 
	
//	@EmbeddedId
//	private CabinetUserId id;
//
//	@OneToMany(cascade={CascadeType.ALL})
//	@JoinTable(name="cabinet_assign_privilege",
//		joinColumns={@JoinColumn(name="cabinet_id",referencedColumnName="cabinetId"),
//				@JoinColumn(name="user_id",referencedColumnName="userId")},
//		inverseJoinColumns={@JoinColumn(name="privilege_id")})
//    private List<Privilege> privileges;
 
	
}
