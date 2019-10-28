package pl.lickerish.kotlincrudmongo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Hotels")
data class Hotel(val name: String,
                 var pricePerNight: Int,
                 var address: Address,
                 var reviews: List<Review>)