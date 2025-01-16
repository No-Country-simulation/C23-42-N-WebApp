package org.nctry.user.domain.dto.response;

import org.nctry.user.domain.enums.Country;
import org.nctry.user.domain.model.User;
import org.nctry.user.domain.model.UserFulldata;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record dtoUser_displayPublicData(
        String username,
        LocalDateTime lastOnlineAt,
        String name,
        String lastName,
        LocalDate birthday,
        Country country,
        String city,
        LocalDateTime createdAt
)
{
    public dtoUser_displayPublicData(User user, UserFulldata userFulldata){
        this(
                user.getUsername(),
                user.getLastOnlineAt(),
                userFulldata.getName(),
                userFulldata.getLastName(),
                userFulldata.getBirthday(),
                userFulldata.getCountry(),
                userFulldata.getCity(),
                userFulldata.getCreatedAt()
        );
    }
}