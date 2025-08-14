package app.duck_image.data.model

import com.google.gson.annotations.SerializedName

data class DuckDto(
    @SerializedName("url")
    val url: String
)
