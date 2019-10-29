package pl.lickerish.kotlincrudmongo.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import pl.lickerish.kotlincrudmongo.model.Hotel
import pl.lickerish.kotlincrudmongo.repositories.HotelRepository
import java.util.*

@RestController
@RequestMapping("/hotels")
class HotelController(@Autowired val hotelRepository: HotelRepository) {

    @GetMapping
    fun getAll(): List<Hotel> {
        return this.hotelRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): Optional<Hotel> {
        return this.hotelRepository.findById(id)
    }

    @GetMapping("/price/{maxPrice}")
    fun getPricePerNight(@PathVariable("maxPrice") maxPrice: Int): List<Hotel> {
        return this.hotelRepository.findByPricePerNightLessThan(maxPrice)
    }

    @GetMapping("/address/{city}")
    fun getByCity(@PathVariable("city") city: String): List<Hotel> {
        return this.hotelRepository.findByCity(city)
    }

    @PostMapping
    fun insert(@RequestBody hotel: Hotel): Hotel {
        return this.hotelRepository.save(hotel)
    }

    @PutMapping
    fun update(@RequestBody hotel: Hotel) {
        this.hotelRepository.insert(hotel)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String) {
        this.hotelRepository.deleteById(id)
    }


}