package my.example.chapter03.view;

import java.io.Serializable;

import jakarta.annotation.PostConstruct;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import my.example.chapter03.model.Date;

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
	
	public void onDateChange(AjaxBehaviorEvent event) {
        log.debug("onDateChange: {}" , date.getSelectedDay());
        date.setSelectedMonth(null);
    }
	 
}
