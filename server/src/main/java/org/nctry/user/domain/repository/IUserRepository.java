package org.nctry.user.domain.repository;

import org.nctry.user.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
