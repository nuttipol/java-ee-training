package my.example.chapter02.view;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import my.example.chapter02.data.Children;
import my.example.chapter02.data.ContactPerson;
import my.example.chapter02.data.Member;
import my.example.chapter02.data.Person;
import my.example.chapter02.service.MemberServiceable;

@Slf4j
@Data
@Named
@ViewScoped
public class MemberBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Member member;
	private List<Member> memberList;

	@Inject
	private MemberServiceable memberService;
    
	@Inject
    private ExternalContext externalContext;
    
	@PostConstruct
	public void init() {
		member = new Member();  
		memberList = memberService.listMember();
	}

	public void saveAction() {
		memberService.createMember(member);
		member = new Member();
		memberList = memberService.listMember();
	}
	
	public void choosePerson() {
        Map<String,String> parameter =  externalContext.getRequestParameterMap();
        
		Map<	String, Object> options = new HashMap<>();
		options.put("resizable", true);
		options.put("draggable", true);
		options.put("width", 600);
		options.put("height", 900);
		options.put("modal", true);
		 
		Map<String, List<String>> params = new HashMap<>();
		if (parameter.containsKey("param1")) {
			params.put("data1", Arrays.asList(parameter.get("param1")));
		}
	      
		PrimeFaces.current().dialog().openDynamic("add-person", options, params);
	}
	

	public void onAddChildren(SelectEvent<?> event) {
		try {
			Person person = (Person) event.getObject();
			Children children = new Children();
			BeanUtils.copyProperties(children, person);
			member.getChildrens().add(children);
		} catch (IllegalAccessException | InvocationTargetException e) {
		} 
	}

	public void onAddContactPerson(SelectEvent<?> event) {
		try {
			Person person = (Person) event.getObject();
			ContactPerson contactPerson = new ContactPerson();
			BeanUtils.copyProperties(contactPerson, person);
			member.getContactPersons().add(contactPerson);
		} catch (IllegalAccessException | InvocationTargetException e) {
		} 
	}
}
