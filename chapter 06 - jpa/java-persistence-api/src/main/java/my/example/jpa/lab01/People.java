package my.example.jpa.lab01;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @see https://docs.oracle.com/javaee/6/api/index.html
 * https://raresql.com/2012/05/01/difference-between-identity-and-sequence/
 */
@Entity
@Table(name="people")
@Getter
@Setter
@ToString
@Slf4j
public class People  {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="name",length=50,nullable=false)
	private String name;
	
	@Column(name="personal_id",length=13,nullable=false,unique=true)
	private String personalId;
	
	@Column(name="height_int",length=3)
	private int heightInt;
	@Column(name="height_integer",length=3)
	private Integer heightInteger;

	@Column(name="weight_double",length=3,precision=2)
	private double weightDouble;
	@Column(name="weight_bigdecimal",length=3,precision=2)
	private BigDecimal weightBigDecimal;

	@Column(name="thai_citizen")
	private boolean thaiCitizen;
	@Column(name="us_citizen")
	private Boolean usCitizen;
	
	// Date Only:
	@Column(name="sql_date")
	private java.sql.Date sqlDate;
    @Temporal(TemporalType.DATE)
	@Column(name="birth_date")
    private java.util.Date birthDate;
    @Temporal(TemporalType.DATE) 
	@Column(name="died_date")
    private java.util.Calendar diedDate;
 
    // Time Only:
	@Column(name="sql_time")
    private java.sql.Time sqlTime;
    @Temporal(TemporalType.TIME)
    @Column(name="birth_time")
    private java.util.Date birthTime;
    @Temporal(TemporalType.TIME)
    @Column(name="died_time")
    private java.util.Calendar diedTime;
 
    // Date and Time:
    @Column(name="sql_datetime")
    private java.sql.Timestamp sqlDateTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="birth_datetime")
    private java.util.Date birthDateTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="died_datetime")
    private java.util.Calendar diedDateTime;
    
    @SuppressWarnings("unused")
	private static int transient1; // not persistent because of static
    private final int transient2 = 0;  // not persistent because of final
    private transient int transient3; // not persistent because of transient
    @Transient 
    private int transient4; // not persistent because of @Transient

    @Embedded 
    private Address address;

	@Embedded
    private MaritalStatus maritalStatus; 
	
	@Version
	@Column(name="version_id")
	private long version;

	@PrePersist
	public void prePersist(){
		log.info("PrePersist ...");
	}
	
	@PostPersist
	public void postPersist(){
		log.info("postPersist ...");
	}

	@PostLoad
	public void postLoad(){
		log.info("postLoad ...");
	}

	@PreUpdate
	public void preUpdate(){
		log.info("preUpdate ...");
	}

	@PostUpdate
	public void postUpdate(){
		log.info("postUpdate ...");
	}

	@PreRemove
	public void preRemove(){
		log.info("preRemove ...");
	}

	@PostRemove
	public void postRemove(){
		log.info("postRemove ...");
	}

}
