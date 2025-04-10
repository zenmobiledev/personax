package com.mobbelldev.personax.data.mapper

import com.mobbelldev.personax.data.source.remote.model.HairDTO
import com.mobbelldev.personax.domain.model.Hair
import javax.inject.Inject

class HairMapper @Inject constructor() {
    fun map(dto: HairDTO?): Hair {
        return Hair(
            color = dto?.color,
            type = dto?.type
        )
    }
}