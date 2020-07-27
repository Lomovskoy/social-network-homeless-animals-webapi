package ru.social.network.homeless.animals.webapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.social.network.homeless.animals.webapi.model.PrivateMessage
import java.util.*

@Repository
interface PrivateMessageRepository : JpaRepository<PrivateMessage, UUID>