package ru.social.network.homeless.animals.webapi.service.impl

import org.springframework.stereotype.Service
import ru.social.network.homeless.animals.webapi.model.Comment
import ru.social.network.homeless.animals.webapi.repository.CommentRepository
import ru.social.network.homeless.animals.webapi.service.CommentService
import java.util.*

@Service
class CommentServiceImpl(val commentRepository: CommentRepository) : CommentService {

    override fun getComment(commentId: UUID): Optional<Comment> {
        return commentRepository.findById(commentId)
    }

    override fun getComments(commentIds: Set<UUID>): List<Comment> {
        return commentRepository.findAllById(commentIds)
    }

    override fun createComment(comment: Comment): Comment {
        return commentRepository.save(comment)
    }

    override fun editComment(comment: Comment): Comment {
        return commentRepository.save(comment)
    }

    override fun deleteComment(commentId: UUID) {
        return commentRepository.deleteById(commentId)
    }
}