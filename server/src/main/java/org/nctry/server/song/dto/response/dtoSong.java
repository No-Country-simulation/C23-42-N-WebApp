package org.nctry.server.song.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nctry.server.song.model.Artist;
import org.nctry.server.song.model.Genre;
import org.nctry.server.song.model.Playlist;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoSong {
    private String name;
    private  String coverPicture;
    private String sourceUrl;
    private int durationSeconds;
    private int likes = 0;
    private boolean isPublic = true;
    private Set<dtoGenre> genres;
    private Set<dtoPlaylist> playlists;
    private Set<dtoArtist> artists;
}