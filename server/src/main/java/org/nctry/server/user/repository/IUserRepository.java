package org.nctry.server.user.repository;

import org.nctry.server.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
