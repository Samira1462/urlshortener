package com.dkb.codechallenge.urlshortener.controller

import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Slf4j
class MyController {

    @GetMapping("/")
    fun home(): String {
        return "Home page"
    }
}