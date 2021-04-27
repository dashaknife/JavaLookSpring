package volos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volos.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { }
