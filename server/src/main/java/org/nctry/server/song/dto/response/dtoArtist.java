package org.nctry.server.song.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nctry.server.song.model.Genre;
import org.nctry.server.song.model.Playlist;
import org.nctry.server.song.model.Song;
import org.nctry.server.user.enums.Country;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoArtist {
    private String name;
    private String lastname;
    private  String coverPicture;
    private Country country;
    private String bio;
    private Set<dtoSong> songs;
    private Set<dtoGenre> genres;
    private Set<dtoPlaylist> playlists;
}