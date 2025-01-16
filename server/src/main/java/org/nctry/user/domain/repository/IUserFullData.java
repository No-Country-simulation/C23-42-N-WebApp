package org.nctry.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.nctry.user.domain.model.UserFulldata;

public interface IUserFullData extends JpaRepository<UserFulldata, Long> {
}
