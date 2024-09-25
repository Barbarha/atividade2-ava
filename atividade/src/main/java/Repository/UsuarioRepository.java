package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import controller.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
