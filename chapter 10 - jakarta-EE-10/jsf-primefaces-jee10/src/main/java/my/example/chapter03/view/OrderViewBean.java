package my.example.chapter03.view;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Setter
@Named
@ViewScoped
public class OrderViewBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productName;
	private List<String> products = new ArrayList<String>();

    public void submit() {
        log.debug("Order Submitted (View): {}", productName);
        products.add(productName);
        productName= null;
    }
}
