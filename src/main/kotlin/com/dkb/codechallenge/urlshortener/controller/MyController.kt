package com.dkb.codechallenge.urlshortener.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController {

    @GetMapping("/")
    fun home(): String {
        return "Home page"
    }
}