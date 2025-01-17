package org.nctry.server.user.repository;

import org.nctry.server.user.model.UserFulldata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserFullData extends JpaRepository<UserFulldata, Long> {
}
