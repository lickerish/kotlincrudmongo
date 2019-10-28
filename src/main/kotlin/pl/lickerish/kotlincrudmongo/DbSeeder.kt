package pl.lickerish.kotlincrudmongo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import pl.lickerish.kotlincrudmongo.model.Address
import pl.lickerish.kotlincrudmongo.model.Hotel
import pl.lickerish.kotlincrudmongo.model.Review
import pl.lickerish.kotlincrudmongo.repositories.HotelRepository


@Component
class DbSeeder : CommandLineRunner {

    var hotelRepository: HotelRepository

    @Autowired
    constructor(hotelRepository: HotelRepository) {
        this.hotelRepository = hotelRepository
    }


    override fun run(vararg args: String?) {
        val marriot = Hotel(
                "Marriot",
                90,
                Address("Poznan", "Poland"),
                listOf(Review("Kate", 8, false),
                        Review("Lady Gaga", 6, true))
        )
        val ibis = Hotel(
                "Ibis",
                20,
                Address("Krakow", "Poland"),
                listOf(Review("Micheal", 9, false),
                        Review("John", 2, true))
        )
        val ibisBudget = Hotel(
                "Ibis Budget",
                5,
                Address("Dubai", "Saudi Arabia"),
                listOf(Review("Albert", 10, false),
                        Review("Eve", 9, true))
        )
        this.hotelRepository.deleteAll();
        this.hotelRepository.save(ibis);
        this.hotelRepository.save(marriot);
        this.hotelRepository.save(ibisBudget);
    }

}
