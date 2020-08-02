package ru.social.network.homeless.animals.webapi.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.social.network.homeless.animals.webapi.dto.CreateUserDTO
import ru.social.network.homeless.animals.webapi.model.User
import ru.social.network.homeless.animals.webapi.service.UserService

@Controller
@RequestMapping("template/")
class TemplateController {

    @GetMapping("reg")
    fun registration(model: Model): String {
        return "reg"
    }

    @GetMapping("login")
    fun greeting(model: Model): String {
        return "login"
    }

    @GetMapping("admin")
    fun admin(model: Model): String {
        return "admin"
    }

}