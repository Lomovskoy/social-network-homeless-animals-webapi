package ru.social.network.homeless.animals.webapi.service.auth

import com.google.common.io.BaseEncoding
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import org.springframework.stereotype.Service
import java.util.*
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import java.time.LocalDateTime
import java.time.ZoneId
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec


@Service
class TokenHandler {

    @Value("\${jwt.secret.key}")
    private lateinit var jwtKey: String
    private lateinit var secretKey: SecretKey

    init {
        val decodedKey = BaseEncoding.base64().decode(jwtKey)
        secretKey = SecretKeySpec(decodedKey, 0, decodedKey.size, "AES")
    }

    fun extractUserId(token: String): Optional<UUID> {
        return try {
            val claimsJws: Jws<Claims> = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
            val body: Claims = claimsJws.body
            Optional.ofNullable(body.id).map(UUID::fromString)
        } catch (e: RuntimeException) {
            Optional.empty()
        }
    }

    fun generateAccessToken(id: UUID, expires: LocalDateTime): String {
        return Jwts.builder()
                .setId(id.toString())
                .setExpiration(Date.from(expires.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact()
    }
}