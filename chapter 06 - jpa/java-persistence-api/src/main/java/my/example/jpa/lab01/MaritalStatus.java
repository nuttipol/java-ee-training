package my.example.jpa.lab01;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class MaritalStatus {
	public static final MaritalStatus SINGLE		=	MaritalStatus.valueOf("S");
	public static final MaritalStatus MARRIED		=	MaritalStatus.valueOf("M");
	public static final MaritalStatus SEPARATED		=	MaritalStatus.valueOf("P");
	public static final MaritalStatus DIVORCED		=	MaritalStatus.valueOf("D");
	 
	@Column(name = "marital_status_code",length=1)
	private String code;
	
	public MaritalStatus(){
		code = MaritalStatus.SINGLE.getCode();
	}
	
	public MaritalStatus(String _status){
		code = _status;
	}
	
	public static MaritalStatus valueOf(String str){
		return new MaritalStatus(str);
	}
 
}
