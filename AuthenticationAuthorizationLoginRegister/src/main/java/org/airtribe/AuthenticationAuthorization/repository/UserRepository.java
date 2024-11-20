package org.airtribe.AuthenticationAuthorization.repository;

import java.util.List;
import org.airtribe.AuthenticationAuthorization.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String username);

  @Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
  List<User> findUserByEmailSafe(@Param("email") String email);

  @Query(value = "SELECT * FROM user WHERE email = ?", nativeQuery = true)
  List<User> findUserByEmailUnsafe(String email);
}
