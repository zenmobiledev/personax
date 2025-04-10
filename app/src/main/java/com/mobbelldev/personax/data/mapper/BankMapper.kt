package com.mobbelldev.personax.data.mapper

import com.mobbelldev.personax.data.source.remote.model.BankDTO
import com.mobbelldev.personax.domain.model.Bank
import javax.inject.Inject

class BankMapper @Inject constructor() {
    fun map(dto: BankDTO?): Bank {
        return Bank(
            iban = dto?.iban,
            cardExpire = dto?.cardExpire,
            cardType = dto?.cardType,
            currency = dto?.currency,
            cardNumber = dto?.cardNumber
        )
    }
}