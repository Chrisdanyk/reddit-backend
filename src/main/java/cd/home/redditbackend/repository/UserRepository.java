package cd.home.redditbackend.repository;

import cd.home.redditbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}