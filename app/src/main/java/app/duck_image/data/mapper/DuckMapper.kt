package app.duck_image.data.mapper

import app.duck_image.data.model.DuckDto
import app.duck_image.domain.model.Duck

fun DuckDto.toDomain() = Duck(imageUrl = url)