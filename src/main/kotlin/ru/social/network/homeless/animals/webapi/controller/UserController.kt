package ru.social.network.homeless.animals.webapi.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.social.network.homeless.animals.webapi.dto.CreateUserDTO
import ru.social.network.homeless.animals.webapi.service.UserService

@Controller
@RequestMapping("user/")
class UserController(val userService: UserService) {

    @PostMapping("reg")
    fun createUser(user: CreateUserDTO): String {
        userService.createUser(user)
        return "redirect:template/login"
    }
}