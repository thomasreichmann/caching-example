package dev.thomasar.cachingexample.services

import dev.thomasar.cachingexample.models.Device
import dev.thomasar.cachingexample.repositories.DeviceRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class DevicesService(
    private val deviceRepository: DeviceRepository
) {
    fun getAll(pageable: Pageable): Page<Device> {
        return deviceRepository.findAll(pageable)
    }

    fun getBySerial(serial: String): Device? {
        return deviceRepository.findBySerial(serial)
    }

    fun save(device: Device): Device {
        return deviceRepository.save(device)
    }

    fun deleteBySerial(serial: String) {
        deviceRepository.deleteBySerial(serial)
    }

    fun updateFaceCountBySerial(serial: String, faceCount: Number): Number {
        return deviceRepository.updateFaceCountBySerial(serial, faceCount)
    }
}