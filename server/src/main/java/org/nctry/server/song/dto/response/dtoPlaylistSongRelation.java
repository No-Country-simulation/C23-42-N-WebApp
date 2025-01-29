package org.nctry.server.song.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoPlaylistSongRelation {
    private Long playlistId;
    private Long songId;
    private LocalDateTime createdAt;
}