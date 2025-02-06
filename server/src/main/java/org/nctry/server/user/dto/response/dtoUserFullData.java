package org.nctry.server.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nctry.server.user.enums.Country;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoUserFullData {
    private String name;
    private String lastName;
    private LocalDate birthday;
    private Country country;
    private String city;
    private LocalDateTime createdAt;
}