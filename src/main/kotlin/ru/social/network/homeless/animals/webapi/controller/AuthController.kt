package ru.social.network.homeless.animals.webapi.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class AuthController {

//    @GetMapping(value = ["/"])
//    fun index(model: Model): String {
//        return "index"
//    }

    @GetMapping(value = ["/reg"])
    fun registration(model: Model): String {
        return "reg"
    }

    @GetMapping(value = ["/login"])
    fun greeting(model: Model): String {
        return "login"
    }

    @GetMapping(value = ["/admin"])
    fun admin(model: Model): String {
        return "admin"
    }
}