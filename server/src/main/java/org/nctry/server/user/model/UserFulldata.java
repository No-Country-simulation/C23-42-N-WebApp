package org.nctry.server.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.nctry.server.model.EntityClass;
import jakarta.persistence.*;
import org.nctry.server.user.enums.Country;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "users_full_data")
public class UserFulldata extends EntityClass {
    @Column(name = "role", columnDefinition = "TINYINT(1) UNSIGNED DEFAULT 0")
    private int role = 0;
    @Column(name = "profile_picture", columnDefinition = "VARCHAR(255) DEFAULT 'public/images/defaultProfilePictureUser.jpg'")
    private String profilePicture = "public/images/defaultProfilePictureUser.jpg";
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(name = "birthday", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthday;
    @Column(name = "phone", unique = true, length = 20)
    private String phone;
    @Column(name = "email", nullable = false, unique = true, length = 80)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "country", nullable = false, length = 14)
    private Country country;
    @Column(name = "city", length = 50)
    private String city;
    @Column(name = "is_confirmed", nullable = false, columnDefinition = "TINYINT(1) UNSIGNED DEFAULT 0")
    private boolean isConfirmed = false;
    @Column(name = "confirmation_code", length = 100)
    private String confirmationCode;
    @Column(name = "recovery_code", length = 100)
    private String recoveryCode;

    private boolean enabled;
    @Column(name = "verification_expiration")
    private LocalDateTime verificationCodeExpiresAt;
}