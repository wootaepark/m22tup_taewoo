package m22t.ansdlsrb.m22tProject.data.repository;

import m22t.ansdlsrb.m22tProject.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity>findByNickname(String nickname);
    boolean existsByEmail(String email);
   boolean existsByNickname(String nickname);
}
