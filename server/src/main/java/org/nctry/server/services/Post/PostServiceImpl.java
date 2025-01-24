package org.nctry.server.services.Post;

import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Override
    public void savePost() {
        /*
            TODO:
                Crear o actualizar post
                Manejo de error unauthorized
        */
    }

    @Override
    public void deletePost(Long postId) {
        /*
            TODO:
                Obtener y eliminar post
                Manejo de error Not Found
        */
    }

    @Override
    public void getPostById(Long postId) {
        /*
            TODO:
                Obtener post especifico
                Manejo de error Not Found
        */
    }

    @Override
    public void getPostByTitle(String title) {
        /*
            TODO:
                Encontrar el conjunto de post que comparten titulo
                devolver un mensaje en especifico con una lista vacia
        */
    }

    @Override
    public void getPostByUser(String user) {
        /*
            TODO:
                Obtengo el USER desde el controler y busco los post que el user posteo
                Devolver una lista vacia sin error (reflejar algun mensaje)
        */
    }

    @Override
    public void getPostBySong(String song) {
        /*
            TODO:
                Mismo proceso que en getPostByUser
                (Este procedimiento encuentra todas los post que posean dicha cancion)
        */
    }

    /*
        TODO:
            MapToDTO
            MapToProduct
    */
}
