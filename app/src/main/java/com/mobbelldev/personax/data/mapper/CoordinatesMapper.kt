package com.mobbelldev.personax.data.mapper

import com.mobbelldev.personax.data.source.remote.model.CoordinatesDTO
import com.mobbelldev.personax.domain.model.Coordinates
import javax.inject.Inject

class CoordinatesMapper @Inject constructor() {
    fun map(dto: CoordinatesDTO?): Coordinates {
        return Coordinates(
            lng = dto?.lng,
            lat = dto?.lat
        )
    }
}