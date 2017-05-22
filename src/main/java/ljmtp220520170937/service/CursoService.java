package ljmtp220520170937.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ljmtp220520170937.entity.Curso;
import ljmtp220520170937.exception.CursoAlreadyExistException;
import ljmtp220520170937.exception.CursoNotFoundException;
import ljmtp220520170937.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;

	@Transactional(readOnly = true)
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Curso findById(Long id) {
		if (!exist(id)) {
			throw new CursoNotFoundException("Curso com esse id não existe: " + id);
		}
		return cursoRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public boolean exist(Long id) {
		return cursoRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public Curso save(Curso p) {

		if (p.getId() != null && exist(p.getId())) {
			throw new CursoAlreadyExistException("Curso com esse id já existe: " + p.getId());
		}

		return cursoRepository.save(p);
	}

	@Transactional(readOnly = false)
	public Curso update(Curso p) {

		if (!exist(p.getId())) {
			throw new CursoNotFoundException("Curso com esse id não existe: " + p.getId());
		}

		return cursoRepository.save(p);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		cursoRepository.delete(id);
	}

	@Transactional(readOnly = false)
	public void delete(Curso p) {
		cursoRepository.delete(p);
	}
}
