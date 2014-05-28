package br.com.academy.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.academy.dao.DAO;
import br.com.academy.model.Modalidade;

@RequestScoped
@ManagedBean
public class ModalidadeBean extends GenericBean {

	private static final long serialVersionUID = -8051486991185309414L;

	private Modalidade modalidade = new Modalidade();

	private List<Modalidade> modalidades;
	
	public void grava(){
		DAO<Modalidade> dao = new DAO<Modalidade>(Modalidade.class);
		if (modalidade.getId() == null) {
			
			dao.adicionar(modalidade);		
			
		}else{
			
			dao.atualizar(modalidade);
		}
	
		addMessage("Salvo com sucesso!");
		modalidades = dao.listaTodos();
		this.modalidade = new Modalidade();				
	}	
	
	public void remove(){
		DAO<Modalidade> dao = new DAO<Modalidade>(Modalidade.class);
		
		dao.remove(modalidade);
		addMessage("Removido");
		this.modalidades = dao.listaTodos();
	}

	public Modalidade getModalidade() {
		return this.modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public List<Modalidade> getModalidades() {
		if (modalidades == null) {
			modalidades = new DAO<Modalidade>(Modalidade.class).listaTodos();
		}
		return modalidades;
	}

	public void setModalidades(List<Modalidade> modalidades) {
		this.modalidades = modalidades;
	}
	
	

}
