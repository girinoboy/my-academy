package br.com.academy.mb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class GenericBean implements Serializable{

	private static final long serialVersionUID = 1L;

	public GenericBean() {
		
	}
			
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
