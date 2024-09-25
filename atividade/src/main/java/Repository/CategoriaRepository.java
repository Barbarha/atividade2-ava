package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import controller.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
