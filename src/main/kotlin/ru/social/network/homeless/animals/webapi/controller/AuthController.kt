package ru.social.network.homeless.animals.webapi.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import ru.social.network.homeless.animals.webapi.model.User
import ru.social.network.homeless.animals.webapi.service.UserService

@Controller
class AuthController(val userService: UserService) {

    @GetMapping("/reg")
    fun registration(model: Model): String {
        return "reg"
    }

    @GetMapping("/login")
    fun greeting(model: Model): String {
        return "login"
    }

    @GetMapping("/admin")
    fun admin(model: Model): String {
        return "admin"
    }

    @PostMapping("/reg")
    fun createUser(user: User, model: Model): String {
        userService.createUser(user)
        return "redirect:/login"
    }

}