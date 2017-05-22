package ljmtp220520170937.representation;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ljmtp220520170937.entity.Curso;

public class CursoRepresentation extends ResourceSupport {
	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private String nome;

	public CursoRepresentation() {

	}

	public CursoRepresentation(Curso curso) {
		this.identifier = curso.getId();
		this.nome = curso.getNome();
	}

	public static Curso build(CursoRepresentation representation) {
		Curso curso = new Curso();
		curso.setId(representation.getIdentifier());
		curso.setNome(representation.getNome());

		return curso;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
