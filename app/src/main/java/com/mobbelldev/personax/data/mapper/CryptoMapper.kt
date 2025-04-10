package com.mobbelldev.personax.data.mapper

import com.mobbelldev.personax.data.source.remote.model.CryptoDTO
import com.mobbelldev.personax.domain.model.Crypto
import javax.inject.Inject

class CryptoMapper @Inject constructor() {
    fun map(dto: CryptoDTO?): Crypto {
        return Crypto(
            wallet = dto?.wallet,
            coin = dto?.coin,
            network = dto?.network
        )
    }
}