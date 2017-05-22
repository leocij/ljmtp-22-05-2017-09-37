package ljmtp220520170937.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ljmtp220520170937.entity.Aluno;
import ljmtp220520170937.entity.Curso;
import ljmtp220520170937.representation.AlunoRepresentation;
import ljmtp220520170937.representation.CursoRepresentation;
import ljmtp220520170937.service.CursoService;

@CrossOrigin
@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<CursoRepresentation>> listAll() {

		List<Curso> cursos = cursoService.findAll();
		List<CursoRepresentation> representation = new ArrayList<>();
		for (Curso p : cursos) {
			representation.add(new CursoRepresentation(p));
		}

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<CursoRepresentation> findById(@PathVariable("id") Long id) {

		Curso curso = cursoService.findById(id);
		CursoRepresentation representation = new CursoRepresentation(curso);

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody CursoRepresentation representation) {

		Curso curso = cursoService.save(CursoRepresentation.build(representation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(curso.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody CursoRepresentation representation,
			@PathVariable("id") Long id) {

		representation.setIdentifier(id);
		cursoService.update(CursoRepresentation.build(representation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<CursoRepresentation> delete(@PathVariable("id") Long id) {

		Curso curso = cursoService.findById(id);
		CursoRepresentation representation = new CursoRepresentation(curso);
		cursoService.delete(curso);
		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{id}/alunos", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<AlunoRepresentation>> findAlunoByIdCurso(@PathVariable("id") Long id) {
		Curso curso = cursoService.findById(id);
		List<Aluno> alunos = curso.getAlunos();
		List<AlunoRepresentation> alunoRepresentation = new ArrayList<>();
		for (Aluno aluno : alunos) {
			alunoRepresentation.add(new AlunoRepresentation(aluno));
		}

		return ResponseEntity.ok(alunoRepresentation);
	}

}
