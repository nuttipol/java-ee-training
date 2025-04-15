package my.example.chapter99.view;

import java.io.Serializable;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import my.example.chapter99.model.Date;

@Slf4j
@Getter
@Setter
@Named
@ViewScoped
public class RegisterBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date date = Date.builder().build(); 
	
	@PostConstruct
	public void init() {
		log.debug("init ....");
	}
	  
	 
}
