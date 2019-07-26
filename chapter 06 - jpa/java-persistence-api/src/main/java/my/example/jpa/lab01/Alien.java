package my.example.jpa.lab01;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="alien")
@Data
@ToString
public class Alien  {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="name",length=50,nullable=false)
	private String name;
	
	@Column(name="height_int",length=3)
	private int heightInt;
	@Column(name="height_integer",length=3)
	private Integer heightInteger;

	@Column(name="weight_double",length=3,precision=2)
	private double weightDouble;
	@Column(name="weight_bigdecimal",length=3,precision=2)
	private BigDecimal weightBigDecimal;

    @Embedded 
    private Address address;

	@Version
	@Column(name="version_id")
	private long version;
 
}
