package com.dkb.codechallenge.urlshortener.dto

data class UrlDto(val originalUrl: String,
                  val expirationDate: String? ="")
