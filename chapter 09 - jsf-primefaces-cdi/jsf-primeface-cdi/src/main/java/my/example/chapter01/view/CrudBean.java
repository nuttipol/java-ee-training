package my.example.chapter01.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.event.SelectEvent;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import my.example.chapter01.model.Employee;
import my.example.chapter01.service.EmployeeServiceable;

@Slf4j
@Getter
@Setter
@Named
@ViewScoped
public class CrudBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mode;
	private Employee employeeCriteria;
	private Employee employeeEdit;
	private Employee selectedEmployee;
	private List<Employee> employeeList;

	@Inject
	private EmployeeServiceable service;
	
	@PostConstruct
	public void init() {
		mode = "R";
		employeeCriteria = new Employee(); 
	}
	
	public void searchBtnOnclick() {
		employeeList = service.search(employeeCriteria);
	}

	public void addBtnOnclick() {
		mode = "C";
		employeeEdit = new Employee();
	}
	
	public void onRowSelect(SelectEvent<Employee> event) {
		try {
			log.debug("onRowSelect : event : {}", event.getObject().getId());
			log.debug("onRowSelect : selectedEmployee : {}", selectedEmployee.getId());

			employeeEdit = new Employee();
			BeanUtils.copyProperties(employeeEdit, selectedEmployee);
			
			mode = "U";
		} catch (Exception e) {
			log.error("BeanUtils.copyProperties Exception ",e);
		}
	}
	 
	public void editBtnOnclick() {
		try {
			log.debug("editBtnOnclick : selectedEmployee : {}", selectedEmployee.getId());
			
			employeeEdit = new Employee();
			BeanUtils.copyProperties(employeeEdit, selectedEmployee);
			
			mode = "U";
		} catch (Exception e) {
			log.error("BeanUtils.copyProperties Exception ",e);
		}
	}

	public void saveBtnOnclick() {
		if (employeeEdit.getYears() < 1) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Age is invalid"));
			return;
		}
		service.add(employeeEdit);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Insert complete"));
		mode = "U";
	}

	public void updateBtnOnclick() {
		if (employeeEdit.getYears() < 1) {
			return;
		}
		service.update(employeeEdit);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Update complete"));
	}

	public void deleteBtnOnclick() {
		service.delete(employeeEdit.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Delete complete"));
	}

	public void backBtnOnclick() {
		mode = "R";
		selectedEmployee = new Employee();
	}
 
	public void resetSearchBtnOnclick() {
		employeeCriteria = new Employee();
		employeeList = new ArrayList<>();
	}
	
	public void resetAddBtnOnclick() {
		employeeEdit = new Employee();
	}
	
	public void resetUpdateBtnOnclick() {
		try {
			employeeEdit = new Employee();
			if (selectedEmployee!=null) BeanUtils.copyProperties(employeeEdit, selectedEmployee);
		} catch (Exception e) {
			log.error("BeanUtils.copyProperties Exception ",e);
		}
	}
	
}
