package com.dkb.codechallenge.urlshortener.controller

import com.dkb.codechallenge.urlshortener.dto.UrlDto
import com.dkb.codechallenge.urlshortener.service.UrlService
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

@RestController
class UrlShortController(private val urlService: UrlService) {

    @PostMapping("/generate")
    fun generateShortLink(@RequestBody urlDto: UrlDto) : String = urlService.generateShortUrl(urlDto);


    @GetMapping("/{short}")
    fun redirect(@PathVariable("short") shortUrl: String, response: HttpServletResponse) = response.sendRedirect(urlService.getEncoded(shortUrl).originalUrl);

}