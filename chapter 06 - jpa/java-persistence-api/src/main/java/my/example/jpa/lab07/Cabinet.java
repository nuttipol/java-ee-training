package my.example.jpa.lab07;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="cabinet")
@Data
@ToString
@EqualsAndHashCode(of="id")
public class Cabinet {

	public Cabinet(){
		
	}
	
	public Cabinet(String name,User owner){
		this.name = name;
		this.owner = owner;
	}
	
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="cabinet_id")
	private int id;

	@Column(name="name",length=100)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="owner_user_id",nullable=false)
	private User owner;

	@OneToMany(targetEntity=CabinetUser.class,
			cascade=CascadeType.ALL,mappedBy="cabinet") 
	public List<CabinetUser> cabinetUsers;
	
	public void addCabinetUser(CabinetUser cabinetUser){
		if (this.cabinetUsers == null){
			this.cabinetUsers = new ArrayList<CabinetUser>();
		}
		this.cabinetUsers.add(cabinetUser);
	}
	
	public void removeCabinetUser(CabinetUser cabinetUser){
		if (this.cabinetUsers == null){
			this.cabinetUsers = new ArrayList<CabinetUser>();
		}

		if (this.cabinetUsers.indexOf(cabinetUser)>-1){
			this.cabinetUsers.remove(this.cabinetUsers.indexOf(cabinetUser));
		}
	}
	
}
