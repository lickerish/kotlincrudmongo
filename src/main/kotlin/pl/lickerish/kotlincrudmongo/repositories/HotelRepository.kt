package pl.lickerish.kotlincrudmongo.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import pl.lickerish.kotlincrudmongo.model.Hotel

@Repository
interface HotelRepository : MongoRepository<Hotel, String> {
    fun findByPricePerNightLessThan(maxPrice: Int): List<Hotel>

    @Query(value = "address.city:?0")
    fun findByCity(city: String): List<Hotel>

}