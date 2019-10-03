package my.example.view;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.event.SelectEvent;

import lombok.Data;
import my.example.data.Children;
import my.example.data.ContactPerson;
import my.example.data.Member;
import my.example.data.Person;
import my.example.service.MemberServiceable;
import my.example.service.impl.MemberService;

@Data
@ManagedBean
@ViewScoped
public class MemberBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Member member;
	private List<Member> memberList;
	
	private transient MemberServiceable memberService;
	
	@PostConstruct
	public void init() {
		memberService = new MemberService() ;
		
		member = new Member();  
		memberList = memberService.listMember();
	}

	public void saveAction() {
		memberService.createMember(member);
		member = new Member();
		memberList = memberService.listMember();
	}
	
	public void onAddChildren(SelectEvent event) {
		try {
			Person person = (Person) event.getObject();
			Children children = new Children();
			BeanUtils.copyProperties(children, person);
			member.getChildrens().add(children);
		} catch (IllegalAccessException | InvocationTargetException e) {
		} 
	}

	public void onAddContactPerson(SelectEvent event) {
		try {
			Person person = (Person) event.getObject();
			ContactPerson contactPerson = new ContactPerson();
			BeanUtils.copyProperties(contactPerson, person);
			member.getContactPersons().add(contactPerson);
		} catch (IllegalAccessException | InvocationTargetException e) {
		} 
	}
}
