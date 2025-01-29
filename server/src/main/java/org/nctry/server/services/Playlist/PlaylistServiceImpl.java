package org.nctry.server.services.Playlist;

import org.springframework.stereotype.Service;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    @Override
    public void savePlayList() {
        //Si la Playlist no existe, crea el objeto, de lo contrario actualiza el objeto
        /*
            TODO:
                Condicional de existencias
                Retorna el DTO del objeto creado o actualizado
                Vincular directamente con el usuario que esta iniciado
        */
    }

    @Override
    public void addSongToPlaylist(Long playlistId, Long songId) {
        /*
            TODO:
                Vincular las songs con una playlist especifica
        */
    }

    @Override
    public void removeSongFromPlaylist(Long playlistId, Long songId) {
        /*
            TODO:
                Desvincular la song de la playlist
                Si la song ya no está vinculada a la lista
        */
    }

    @Override
    public void getPlaylistById(Long playlistId) {
        /*
            TODO:
                Obtener la playlist por id
                Si no existe devolver 404
        */
    }

    @Override
    public void getAllPlaylists() {
        /*
            TODO:
                Obtener la lista de playlist entera
        */
    }

    @Override
    public void deletePlaylistById(Long playlistId) {
        /*
            TODO:
                Eliminar por id de la playlist
                Devolver 404 si el objeto no existe
        */
    }

    /*
        TODO:
         MapToDTO
         MapToSong
            Condicional si el objeto existe o no (boolean)
    */
}
