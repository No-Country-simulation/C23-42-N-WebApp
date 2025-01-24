package org.nctry.server.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nctry.server.user.enums.Country;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFullDataDTO {
    private String name;
    private String lastName;
    private LocalDate birthday;
    private Country country;
    private String city;
    private LocalDateTime createdAt;
}
