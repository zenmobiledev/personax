package com.mobbelldev.personax.data.mapper

import com.mobbelldev.personax.data.source.remote.model.AddressDTO
import com.mobbelldev.personax.domain.model.Address
import javax.inject.Inject

class AddressMapper @Inject constructor(private val coordinatesMapper: CoordinatesMapper) {
    fun map(dto: AddressDTO?): Address {
        return Address(
            country = dto?.country,
            address = dto?.address,
            city = dto?.city,
            postalCode = dto?.postalCode,
            coordinates = coordinatesMapper.map(
                dto = dto?.coordinatesDTO
            ),
            stateCode = dto?.stateCode,
            state = dto?.state
        )
    }
}