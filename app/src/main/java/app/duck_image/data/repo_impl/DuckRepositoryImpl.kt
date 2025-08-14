package app.duck_image.data.repo_impl

import app.duck_image.data.mapper.toDomain
import app.duck_image.data.remote.DuckApi
import app.duck_image.domain.model.Duck
import app.duck_image.domain.repo.DuckRepository
import javax.inject.Inject

class DuckRepositoryImpl @Inject constructor(
    private val duckApi: DuckApi
): DuckRepository {
    override suspend fun getRandomDuck(): Duck {
        return duckApi.getRandomDuck().toDomain()
    }
}