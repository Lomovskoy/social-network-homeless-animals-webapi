package ru.social.network.homeless.animals.webapi.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller("/")
class MainController {

    @GetMapping
    fun registration(model: Model): String {
        return "index"
    }
}