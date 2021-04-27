package volos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volos.model.RoleUser;

@Repository
public interface RoleRepository extends JpaRepository<RoleUser, Long> {

}
