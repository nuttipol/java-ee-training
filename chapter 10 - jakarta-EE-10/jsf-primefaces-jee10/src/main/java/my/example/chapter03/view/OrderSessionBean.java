package my.example.chapter03.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@Named
@SessionScoped
public class OrderSessionBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productName;
	private List<String> products = new ArrayList<String>();

    public void submit() {
    	log.debug("Order Submitted (Session): {}", productName);
    	products.add(productName);
        productName= null;
    }
}
