package org.nctry.server.user.repository;

import org.nctry.server.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUserFullData_Email(String email);
    Optional<User> findByUsernameOrUserFullData_Email(String username, String email);
    Optional<User> findUserByEmail(String email);

    @Query("SELECT u FROM User u JOIN FETCH u.userFullData WHERE u.username = :username")
    Optional<User> findByUsernameWithFullData(@Param("username") String username);

}
