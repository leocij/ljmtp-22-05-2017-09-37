package ljmtp220520170937.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long cpf;
	private String matricula;
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id")
	private Curso curso_id;

	public Aluno() {
		super();
	}

	public Aluno(Long cpf, String matricula, String nome, Curso curso_id) {
		super();
		this.cpf = cpf;
		this.matricula = matricula;
		this.nome = nome;
		this.curso_id = curso_id;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(Curso curso_id) {
		this.curso_id = curso_id;
	}

	@Override
	public String toString() {
		return "Aluno [cpf=" + cpf + ", matricula=" + matricula + ", nome=" + nome + ", curso_id=" + curso_id + "]";
	}

}
