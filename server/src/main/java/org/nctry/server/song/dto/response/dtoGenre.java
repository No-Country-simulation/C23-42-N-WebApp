package org.nctry.server.song.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nctry.server.song.model.Playlist;
import org.nctry.server.song.model.Song;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoGenre {
    private String name;
    private String description;
    private Set<dtoSong> songs;
    private Set<dtoPlaylist> playlists;
}
