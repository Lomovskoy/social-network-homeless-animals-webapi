package ru.social.network.homeless.animals.webapi.service

import ru.social.network.homeless.animals.webapi.model.PrivateMessage
import java.util.*

interface PrivateMessageService {

    fun getPrivateMessage(privateMessageId: UUID): Optional<PrivateMessage>

    fun getPrivateMessages(privateMessageIds: Set<UUID>): List<PrivateMessage>

    fun createPrivateMessage(privateMessage: PrivateMessage): PrivateMessage

    fun editPrivateMessage(privateMessage: PrivateMessage): PrivateMessage

    fun deletePrivateMessage(privateMessageId: UUID)
    
}