package com.dkb.codechallenge.urlshortener

import com.dkb.codechallenge.urlshortener.dto.UrlDto
import com.dkb.codechallenge.urlshortener.service.UrlService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@AutoConfigureMockMvc
@SpringBootTest
class UrlServiceTest @Autowired constructor (private val service: UrlService, @Autowired val mockMvc: MockMvc)  {

    @Test
    fun testGenerateShortUrlRepeat() {
        val urlDtoOne = UrlDto("https://www.baeldung.com/kotlin/spring-boot-testing", "2022-07-20T17:06:51.441235")
        val result = getShortUrl(urlDtoOne)
        val urlDtoTwo = UrlDto("https://www.baeldung.com/kotlin/spring-boot-testing", "2022-07-20T17:06:51.451235")
        val result2 = service.generateShortUrl(urlDtoTwo)
        assert(result == result2)

    }

    @Test
    fun testGenerateShortUrl() {
        val urlDtoOne = UrlDto("https://www.baeldung.com/kotlin/spring-boot-testing", "2022-07-20T17:06:51.441235")
        val result = getShortUrl(urlDtoOne)
        assert(result.length == 8)
    }

    private fun getShortUrl(urlDtoOne: UrlDto): String {
        val urlDtoOne = UrlDto("https://www.baeldung.com/kotlin/spring-boot-testing", "2022-07-20T17:06:51.441235")
        return service.generateShortUrl(urlDtoOne)
    }

    @Test
    fun canGetShortUrl() {
        val urlDtoOne = UrlDto("https://www.baeldung.com/kotlin/spring-boot-testing", "2022-07-20T17:06:51.441235")
        val hashcode = getShortUrl(urlDtoOne)
        mockMvc.get("/" + hashcode)
            .andExpect { status { is3xxRedirection() }}
            .andExpect { redirectedUrl("https://www.baeldung.com/kotlin/spring-boot-testing") }
    }

 }
