package com.mobbelldev.personax.data.mapper

import com.mobbelldev.personax.data.source.remote.model.CompanyDTO
import com.mobbelldev.personax.domain.model.Company
import javax.inject.Inject

class CompanyMapper @Inject constructor(private val addressMapper: AddressMapper) {
    fun map(dto: CompanyDTO?): Company {
        return Company(
            address = addressMapper.map(
                dto = dto?.addressDTO
            ),
            name = dto?.name,
            department = dto?.department,
            title = dto?.title
        )
    }
}