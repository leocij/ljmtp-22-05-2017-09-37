package ljmtp220520170937.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ljmtp220520170937.entity.Aluno;
import ljmtp220520170937.exception.AlunoAlreadyExistException;
import ljmtp220520170937.exception.AlunoNotFoundException;
import ljmtp220520170937.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRepository;

	@Transactional(readOnly = true)
	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Aluno findById(Long id) {
		if (!exist(id)) {
			throw new AlunoNotFoundException("Aluno com esse id não existe: " + id);
		}
		return alunoRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public boolean exist(Long id) {
		return alunoRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public Aluno save(Aluno p) {

		if (p.getCpf() != null && exist(p.getCpf())) {
			throw new AlunoAlreadyExistException("Aluno com esse id já existe: " + p.getCpf());
		}

		return alunoRepository.save(p);
	}

	@Transactional(readOnly = false)
	public Aluno update(Aluno p) {

		if (!exist(p.getCpf())) {
			throw new AlunoNotFoundException("Aluno com esse id não existe: " + p.getCpf());
		}

		return alunoRepository.save(p);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		alunoRepository.delete(id);
	}

	@Transactional(readOnly = false)
	public void delete(Aluno p) {
		alunoRepository.delete(p);
	}
}
