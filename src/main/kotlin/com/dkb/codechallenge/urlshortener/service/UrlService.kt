package com.dkb.codechallenge.urlshortener.service

import com.dkb.codechallenge.urlshortener.dto.UrlDto
import com.dkb.codechallenge.urlshortener.model.entity.Url

interface UrlService {

    fun generateShortUrl(urlDto: UrlDto): String
    fun persistShortUrl(url: Url): Url
    fun getEncoded(url: String): Url

}