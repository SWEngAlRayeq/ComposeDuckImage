package app.duck_image.data.remote

import app.duck_image.data.model.DuckDto
import retrofit2.http.GET

interface DuckApi {

    @GET("random")
    suspend fun getRandomDuck(): DuckDto

}