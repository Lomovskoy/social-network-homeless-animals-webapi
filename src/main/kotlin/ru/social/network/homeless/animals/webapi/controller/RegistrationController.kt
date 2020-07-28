package ru.social.network.homeless.animals.webapi.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class RegistrationController {

    @GetMapping(value = ["/registration"])
    fun greeting(@RequestParam(name = "name", required = false, defaultValue = "Мир!") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "registration"
    }
}