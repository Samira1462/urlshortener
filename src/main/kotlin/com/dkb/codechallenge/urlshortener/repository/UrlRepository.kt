package com.dkb.codechallenge.urlshortener.repository

import com.dkb.codechallenge.urlshortener.model.entity.Url
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlRepository : JpaRepository<Url, Long> {

    fun findByShortLink(shortLink: String) :Url?

    fun findByOriginalUrl(originalUrl: String) :Url?
}