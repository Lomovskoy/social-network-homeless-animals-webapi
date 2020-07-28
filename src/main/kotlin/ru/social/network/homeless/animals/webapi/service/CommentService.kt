package ru.social.network.homeless.animals.webapi.service

import ru.social.network.homeless.animals.webapi.model.Comment
import java.util.*

interface CommentService {

    fun getComment(commentId: UUID): Optional<Comment>

    fun getComments(commentIds: Set<UUID>): List<Comment>

    fun createComment(comment: Comment): Comment

    fun editComment(comment: Comment): Comment

    fun deleteComment(commentId: UUID)
    
}