package ljmtp220520170937.representation;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ljmtp220520170937.entity.Aluno;
import ljmtp220520170937.entity.Curso;

public class AlunoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private String matricula;
	@JsonInclude(Include.NON_NULL)
	private String nome;
	@JsonInclude(Include.NON_NULL)
	private CursoRepresentation curso;

	public AlunoRepresentation() {
		super();
	}

	public AlunoRepresentation(Aluno aluno) {
		super();
		this.identifier = aluno.getCpf();
		this.matricula = aluno.getMatricula();
		this.nome = aluno.getNome();

		if (aluno.getCurso_id() != null) {
			Curso curso = aluno.getCurso_id();
			CursoRepresentation cursoRepresentation = new CursoRepresentation(curso);
			this.setCurso(cursoRepresentation);
		}
	}

	public static Aluno build(AlunoRepresentation alunoRepresentation) {
		Aluno aluno = new Aluno();
		aluno.setCpf(alunoRepresentation.getIdentifier());
		aluno.setMatricula(alunoRepresentation.getMatricula());
		aluno.setNome(alunoRepresentation.getNome());

		if (alunoRepresentation.getCurso() != null) {
			CursoRepresentation cursoRepresentation = alunoRepresentation.getCurso();
			Curso curso = CursoRepresentation.build(cursoRepresentation);
			aluno.setCurso_id(curso);
		}

		return aluno;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
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

	public CursoRepresentation getCurso() {
		return curso;
	}

	public void setCurso(CursoRepresentation curso) {
		this.curso = curso;
	}

}
