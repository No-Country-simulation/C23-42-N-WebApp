package org.nctry.server.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoUserFriendsRelation {
    private Long userId;
    private Long friendId;
    private LocalDateTime createdAt;
}