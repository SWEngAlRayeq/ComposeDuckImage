package app.duck_image.domain.usecase

import app.duck_image.domain.model.Duck
import app.duck_image.domain.repo.DuckRepository
import javax.inject.Inject

class GetRandomDuckUseCase @Inject constructor(
    private val duckRepository: DuckRepository
) {
    suspend operator fun invoke(): Duck {
        return duckRepository.getRandomDuck()
    }
}