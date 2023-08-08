package dev.thomasar.cachingexample.controllers

import dev.thomasar.cachingexample.models.Device
import dev.thomasar.cachingexample.services.DevicesService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/devices")
class DevicesController(
    private val devicesService: DevicesService
) {
    @GetMapping
    fun getDevices(pageable: Pageable): Page<Device> {
        return devicesService.getAll(pageable)
    }

    @GetMapping("/serial/{serial}")
    fun getDeviceBySerial(@PathVariable serial: String): Device? {
        return devicesService.getBySerial(serial)
    }

    @PostMapping
    fun saveDevice(@RequestBody device: Device): Device {
        return devicesService.save(device)
    }

    @PutMapping
    fun updateDevice(@RequestBody device: Device): Device {
        return devicesService.save(device)
    }

    @DeleteMapping("/serial/{serial}")
    fun deleteDeviceBySerial(@PathVariable serial: String) {
        devicesService.deleteBySerial(serial)
    }

    @PutMapping("/serial/{serial}/face-count/{faceCount}")
    fun updateFaceCountBySerial(
        @PathVariable serial: String,
        @PathVariable faceCount: Number
    ): Number {
        return devicesService.updateFaceCountBySerial(serial, faceCount)
    }
}