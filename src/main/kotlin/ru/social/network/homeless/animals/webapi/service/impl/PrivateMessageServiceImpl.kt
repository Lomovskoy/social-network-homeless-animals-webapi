package ru.social.network.homeless.animals.webapi.service.impl

import org.springframework.stereotype.Service
import ru.social.network.homeless.animals.webapi.model.PrivateMessage
import ru.social.network.homeless.animals.webapi.repository.PrivateMessageRepository
import ru.social.network.homeless.animals.webapi.service.PrivateMessageService
import java.util.*

@Service
class PrivateMessageServiceImpl(val privateMessageRepository: PrivateMessageRepository) : PrivateMessageService {

    override fun getPrivateMessage(privateMessageId: UUID): Optional<PrivateMessage> {
        return privateMessageRepository.findById(privateMessageId)
    }

    override fun getPrivateMessages(privateMessageIds: Set<UUID>): List<PrivateMessage> {
        return privateMessageRepository.findAllById(privateMessageIds)
    }

    override fun createPrivateMessage(privateMessage: PrivateMessage): PrivateMessage {
        return privateMessageRepository.save(privateMessage)
    }

    override fun editPrivateMessage(privateMessage: PrivateMessage): PrivateMessage {
        return privateMessageRepository.save(privateMessage)
    }

    override fun deletePrivateMessage(privateMessageId: UUID) {
        return privateMessageRepository.deleteById(privateMessageId)
    }
}