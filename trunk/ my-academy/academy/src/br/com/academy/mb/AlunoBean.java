package br.com.academy.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.academy.dao.DAO;
import br.com.academy.model.Aluno;

@ViewScoped
@ManagedBean
public class AlunoBean extends GenericBean{
	
	private static final long serialVersionUID = -5330598060587240147L;
	
	private Aluno aluno = new Aluno();
	private List<Aluno> alunos;
	
	public void grava(){
		DAO<Aluno> dao = new DAO<Aluno>(Aluno.class);
		if (aluno.getId() == null) {
			
			dao.adicionar(aluno);		
			
		}else{
			
			dao.atualizar(aluno);
		}
		addMessage("Salvo com sucesso!");
	
		alunos = dao.listaTodos();
		this.aluno = new Aluno();				
	}	
	
	public void remove(Aluno aluno){
		DAO<Aluno> dao = new DAO<Aluno>(Aluno.class);
		dao.remove(aluno);
		addMessage("Removido");
		this.alunos = dao.listaTodos();
	}
	
	public List<Aluno> getAlunos() {
		if (alunos == null) {
			alunos = new DAO<Aluno>(Aluno.class).listaTodos();
		}
		
		return alunos;
	}



	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}



	public Aluno getAluno() {
		return this.aluno;		
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
