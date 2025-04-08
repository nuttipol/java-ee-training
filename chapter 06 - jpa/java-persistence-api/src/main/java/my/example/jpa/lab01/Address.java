package my.example.jpa.lab01;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class Address {
	
	@Column(name="houseNo")
    private String houseNo;
	
	@Column(name="street")
    private String street;
	
	@Column(name="city")
    private String city;
	
	@Column(name="state")
    private String state;
	
	@Column(name="country")
    private String country;
	
	@Column(name="zip")
    private String zip;
    
    
}
