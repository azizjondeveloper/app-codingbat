package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User,UUID> {




    boolean existsByUsername(String username);


    Optional<User> findByUsername(String username);

    Optional<User> findByEmailCode(UUID code);
}

