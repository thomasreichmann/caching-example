package dev.thomasar.cachingexample.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document("devices")
data class Device(
    @Id
    val id: String? = null,
    val serial: String,
    val description: String,
    val faceCount: Number,
    val lastSyncedAt: Instant,
)