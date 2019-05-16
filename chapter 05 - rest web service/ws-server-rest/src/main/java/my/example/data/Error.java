package my.example.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

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
