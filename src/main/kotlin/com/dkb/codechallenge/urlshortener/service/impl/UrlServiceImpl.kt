package com.dkb.codechallenge.urlshortener.service.impl

import com.dkb.codechallenge.urlshortener.dto.UrlDto
import com.dkb.codechallenge.urlshortener.model.entity.Url
import com.dkb.codechallenge.urlshortener.repository.UrlRepository
import com.dkb.codechallenge.urlshortener.service.UrlService
import com.google.common.hash.Hashing
import mu.KotlinLogging
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime

@Service
@CacheConfig(cacheNames=["Url"])
class UrlServiceImpl(private val urlRepository: UrlRepository): UrlService {

    val logger = KotlinLogging.logger {}

    override fun generateShortUrl(urlDto: UrlDto): String {
        val encodeUrl = encoderUrl(urlDto.originalUrl)
        return if (urlDto.originalUrl.isNotEmpty())
            persistShortUrl(Url(null, urlDto.originalUrl, encodeUrl, LocalDateTime.now(), getExpirationDate(urlDto.expirationDate, LocalDateTime.now()))).shortLink
        else
            logger.info {"short url not created------->"}.toString()
    }


    private fun getExpirationDate(expirationDate: String?, creationDate: LocalDateTime): LocalDateTime {
        if (expirationDate?.isBlank()!!) {
            return creationDate.plusMinutes(60)
        }
        return LocalDateTime.parse(expirationDate)
    }

    private fun encoderUrl(originalUrl: String): String {
        val time = LocalDateTime.now()
        return Hashing.murmur3_32().hashString(originalUrl.plus(time.toString()), StandardCharsets.UTF_8).toString()
    }

    @Cacheable
    fun findOriginalUrl(url: String) = urlRepository.findByOriginalUrl(url);

    override fun persistShortUrl(url: Url): Url {
        val originalUrl = findOriginalUrl(url.originalUrl);
        return if (originalUrl == null) {
            urlRepository.save(url)
        } else {
            getEncoded(originalUrl.shortLink)
        }
    }


    @Cacheable(value = ["Url"] )
    override fun getEncoded(url: String): Url {
        val result = urlRepository.findByShortLink(url)
        if (result == null) {
            throw Exception();
        }else{
            return result
        }
    }
}