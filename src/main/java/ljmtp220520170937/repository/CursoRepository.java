package ljmtp220520170937.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ljmtp220520170937.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
