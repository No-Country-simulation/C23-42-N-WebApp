package org.nctry.server.services.Comment;

import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public void saveComment(String comment) {
        /*
            TODO:
                Crear o actualizar el comment
                Manejo de error 403
        */
    }

    @Override
    public void deleteComment(Long commentId) {
        /*
            TODO:
                Obtener y eliminar el comentario
                Manejo de error 404
        */
    }

    @Override
    public void getCommentById(Long user) {

    }

    @Override
    public void getCommentByPost(String post) {
        /*
            TODO:
                Obtener el post desde controller
                Devolver lista vacia si la publicacion no tiene comentarios
        */
    }

    @Override
    public void getRepliesToComment(Long commentId) {
        /*
            TODO:
                Obtener caracteristicas replies por comentario seleccionad
                devolver lista vacia si no hay replies
        */
    }

    @Override
    public void addRepliesToComment(Long commentId) {
        /*
            TODO:
                Obtener el comentario y añadir un replie
                Devolver un 404 si no existe
        */
    }

    @Override
    public void addReactionToComment(Long commentId, Long reactionId, Long userId) {
        /*
            TODO:
                Añador una reaccion al comentario seleccionado
                Vincular la reaccion a los USER
        */
    }
}
