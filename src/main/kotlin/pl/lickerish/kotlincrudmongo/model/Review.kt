package pl.lickerish.kotlincrudmongo.model

data class Review(val userName: String,
                  val rating: Int,
                  val approved: Boolean)

