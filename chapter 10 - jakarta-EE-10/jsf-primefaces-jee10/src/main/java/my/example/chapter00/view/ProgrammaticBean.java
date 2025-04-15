package my.example.chapter00.view;

import java.io.IOException;
import java.io.Serializable;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.View;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIOutput;
import jakarta.faces.component.html.HtmlBody;
import jakarta.faces.component.html.HtmlCommandButton;
import jakarta.faces.component.html.HtmlForm;
import jakarta.faces.component.html.HtmlOutputText;
import jakarta.faces.component.html.HtmlPanelGrid;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.facelets.Facelet;
import jakarta.servlet.http.HttpServletRequest;

@ApplicationScoped
@View("/hello.xhtml")
public class ProgrammaticBean extends Facelet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void apply(FacesContext facesContext, UIComponent root) throws IOException {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		if (request.getParameter("value") == null) {
			HtmlPanelGrid panelGrid = new HtmlPanelGrid();
			HtmlOutputText outputText = new HtmlOutputText();
			outputText.setValue("Hello, Programmatic View!");
			panelGrid.getChildren().add(outputText);
			facesContext.getViewRoot().getChildren().add(panelGrid);
		}else {
			var components = new ComponentBuilder(facesContext);
			var rootChildren = root.getChildren();
	
			var doctype = new UIOutput();
			doctype.setValue("<!DOCTYPE html>");
			rootChildren.add(doctype);
	
			var htmlTag = new UIOutput();
			htmlTag.setValue("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
			rootChildren.add(htmlTag);
	
			HtmlBody body = components.create(HtmlBody.COMPONENT_TYPE);
			rootChildren.add(body);
	
			HtmlForm form = components.create(HtmlForm.COMPONENT_TYPE);
			form.setId("form");
			body.getChildren().add(form);
	
			HtmlOutputText message = components.create(HtmlOutputText.COMPONENT_TYPE);
			message.setId("message");
	
			HtmlCommandButton actionButton = components.create(HtmlCommandButton.COMPONENT_TYPE);
			actionButton.setId("button");
			actionButton.addActionListener(e -> message.setValue("Hello, World! Welcome to Faces 4.0 on Jakarta EE 10"));
			actionButton.setValue(request.getParameter("value"));
	
			form.getChildren().add(actionButton);
	
			root.getChildren().add(message);
	
			htmlTag = new UIOutput();
			htmlTag.setValue("</html>");
			rootChildren.add(htmlTag);
		}
	}

	private static class ComponentBuilder {
		FacesContext facesContext;

		ComponentBuilder(FacesContext facesContext) {
			this.facesContext = facesContext;
		}

		@SuppressWarnings("unchecked")
		<T> T create(String componentType) {
			return (T) facesContext.getApplication().createComponent(facesContext, componentType, null);
		}
	}

}
