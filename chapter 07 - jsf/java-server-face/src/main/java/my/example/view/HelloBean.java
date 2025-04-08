package my.example.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class HelloBean  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
}
