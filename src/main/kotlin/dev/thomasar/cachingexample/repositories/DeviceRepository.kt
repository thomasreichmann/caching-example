package dev.thomasar.cachingexample.repositories

import dev.thomasar.cachingexample.models.Device
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.Update

interface DeviceRepository : MongoRepository<Device, String> {
    fun findBySerial(serial: String): Device?

    fun deleteBySerial(serial: String)

    @Query("{'serial': ?0}")
    @Update("{\$set: {'faceCount': ?1}}")
    fun updateFaceCountBySerial(serial: String, faceCount: Number): Number
}