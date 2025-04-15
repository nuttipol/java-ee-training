package my.example.chapter03.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Date implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Default
	private String selectedDay = "1";
    private String selectedMonth;
    private String selectedYear;
    
    @Default
    private List<String> years = Arrays.asList("2021", "2022", "2023", "2024", "2025");

    public List<String> getDays() {
        return IntStream.rangeClosed(1, 31)
                .boxed()
                .map(e->e.toString())
                .collect(Collectors.toList());
    }
    
    public List<String> getMonths(){
    	if (selectedDay.equals("31")) {
    		return Arrays.asList("January", "March", "May", "July", "August", "October", "December");
    	}else if (selectedDay.equals("30")) {
    		return Arrays.asList("January", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    	}else {
    		return Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    	}
    }
}
