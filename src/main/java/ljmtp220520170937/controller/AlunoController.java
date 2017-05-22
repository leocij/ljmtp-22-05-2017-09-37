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
import ljmtp220520170937.representation.AlunoRepresentation;
import ljmtp220520170937.service.AlunoService;

@CrossOrigin
@RestController
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	private AlunoService alunoService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<AlunoRepresentation>> listAll() {

		List<Aluno> alunos = alunoService.findAll();
		List<AlunoRepresentation> representation = new ArrayList<>();
		for (Aluno p : alunos) {
			representation.add(new AlunoRepresentation(p));
		}

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<AlunoRepresentation> findById(@PathVariable("id") Long id) {

		Aluno aluno = alunoService.findById(id);
		AlunoRepresentation representation = new AlunoRepresentation(aluno);

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody AlunoRepresentation alunoRepresentation) {

		Aluno aluno = alunoService.save(AlunoRepresentation.build(alunoRepresentation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getCpf()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody AlunoRepresentation representation,
			@PathVariable("id") Long id) {

		representation.setIdentifier(id);
		alunoService.update(AlunoRepresentation.build(representation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<AlunoRepresentation> delete(@PathVariable("id") Long id) {

		Aluno aluno = alunoService.findById(id);
		AlunoRepresentation representation = new AlunoRepresentation(aluno);
		alunoService.delete(aluno);
		return ResponseEntity.ok(representation);
	}
}
