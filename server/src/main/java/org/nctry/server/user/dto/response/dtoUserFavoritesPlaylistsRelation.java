package org.nctry.server.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoUserFavoritesPlaylistsRelation {
    private Long userId;
    private Long playlistId;
    private LocalDateTime createdAt;
}