package by.javatrenning.blog.repos;

import by.javatrenning.blog.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByActivationCode(String activationCode);
}
