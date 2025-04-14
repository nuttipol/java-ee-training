package my.example.data;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD) 
public class Error {
	
	public Error(){
		
	}
	
	public Error(String code, String message){
		this.code = code;
		this.message = message;
	}
	
	private String code;
	private String message;
}
