package org.nctry.server.services.Song;

import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {

    @Override
    public /*SongDTO*/ void saveSong(/*SongDTO songDTO*/) {
        //Si la song no existe, crea el objeto, de lo contrario actualiza el objeto
        /*
            TODO:
                Condicional de existencias
                Retorna el DTO del objeto creado o actualizado
        */
    }

    @Override
    public void deleteSongById(Long id) {
        /*
            TODO:
                Eliminar Song por Id en caso de que exista
                Devolver un 404 en caso de que no exista
                Devolver un 403 en caso de no estar autorizado
        */
    }

    @Override
    public void deleteSong(/*SongDTO songDTO*/){
        /*
            TODO:
             Obtener mapear DTO a Song,
             Si no existe, error 404
             Si no autorizado, error 403
             Si existe y esta autorizado eliminar
        */
    }

    @Override
    public /*SongDTO*/ void getSongById(Long id) {
        /*
            TODO:
                Obtengo la Song por el id,
                Si no existe devuelvo un error 404,
                Si existe aplico MapToDTO y devuelvo el DTO del objeto
        */
    }

    @Override
    public /*List<SongDTO>*/ void getAllSong() {
        /*
            TODO:
             Si la lista esta vacia, devolver 404
             Devolver todas las Songs
        */
    }

    @Override
    public /*List<SongDTO>*/ void getAllSongByName(String name) {
        /*
            TODO:
                Mismo manejo de que getAllSong
        */
    }

    @Override
    public void likeSong(Long userId, Long songId) {
        /*
            TODO:
                Vincular cada cancion a 1 like por usuario
                Aumentar el contador de likes de la publicacion en 1 por cada vez que se le de
        */
    }

    /*
        TODO:
         MapToDTO
         MapToSong
            Condicional si el objeto existe o no (boolean)
    */

}
