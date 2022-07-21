package com.dkb.codechallenge.urlshortener.model.entity

import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(indexes = [Index(name = "shortLink", columnList = "shortLink")])
data class Url(
    @Id
    @GeneratedValue(generator = "incremental_id")
    @GenericGenerator(name = "incremental_id", strategy = "increment")
    @Column(name = "ID", nullable = false, unique = true, updatable = false)
    var id: Long ? = null,
    @Lob
    var originalUrl: String,
    var shortLink: String,
    var creationDate: LocalDateTime,
    var expirationDate: LocalDateTime
)
