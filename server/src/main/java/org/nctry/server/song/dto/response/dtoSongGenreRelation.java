package org.nctry.server.song.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoSongGenreRelation {
    private Long songId;
    private Long genreId;
}