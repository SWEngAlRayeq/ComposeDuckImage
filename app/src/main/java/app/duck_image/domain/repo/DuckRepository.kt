package app.duck_image.domain.repo

import app.duck_image.domain.model.Duck

interface DuckRepository {
    suspend fun getRandomDuck(): Duck
}