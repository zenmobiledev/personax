package com.mobbelldev.personax.data.mapper

import com.mobbelldev.personax.data.source.remote.model.AddressDTO
import com.mobbelldev.personax.data.source.remote.model.BankDTO
import com.mobbelldev.personax.data.source.remote.model.CompanyDTO
import com.mobbelldev.personax.data.source.remote.model.CoordinatesDTO
import com.mobbelldev.personax.data.source.remote.model.CryptoDTO
import com.mobbelldev.personax.data.source.remote.model.HairDTO
import com.mobbelldev.personax.data.source.remote.model.UsersItemDTO
import com.mobbelldev.personax.data.source.remote.model.response.UserResponse
import com.mobbelldev.personax.domain.model.Address
import com.mobbelldev.personax.domain.model.Bank
import com.mobbelldev.personax.domain.model.Company
import com.mobbelldev.personax.domain.model.Coordinates
import com.mobbelldev.personax.domain.model.Crypto
import com.mobbelldev.personax.domain.model.Hair
import com.mobbelldev.personax.domain.model.User
import com.mobbelldev.personax.domain.model.UsersItem
import javax.inject.Inject

class Mapper @Inject constructor() {
    fun mapResponseToDomain(response: UserResponse): User {
        return User(
//            total = ,
//            limit = ,
//            skip = ,
            users = response.users?.map { mapResponseToDomain(usersItemDTO = it) }
        )
    }

    private fun mapResponseToDomain(usersItemDTO: UsersItemDTO?): UsersItem {
        return UsersItem(
            fullName = usersItemDTO?.firstName + " " + usersItemDTO?.lastName,
            lastName = usersItemDTO?.lastName,
            role = usersItemDTO?.role,
            gender = usersItemDTO?.gender,
            university = usersItemDTO?.university,
            maidenName = usersItemDTO?.maidenName,
            ein = usersItemDTO?.ein,
            ssn = usersItemDTO?.ssn,
            bloodGroup = usersItemDTO?.bloodGroup,
            password = usersItemDTO?.password,
            hair = mapResponseToDomain(hairDTO = usersItemDTO?.hairDTO),
            bank = mapResponseToDomain(bankDTO = usersItemDTO?.bankDTO),
            eyeColor = usersItemDTO?.eyeColor,
            company = mapResponseToDomain(companyDTO = usersItemDTO?.companyDTO),
            id = usersItemDTO?.id,
            email = usersItemDTO?.email,
            height = usersItemDTO?.height,
            image = usersItemDTO?.image,
            address = mapResponseToDomain(addressDTO = usersItemDTO?.addressDTO),
            ip = usersItemDTO?.ip,
            weight = usersItemDTO?.weight,
            userAgent = usersItemDTO?.userAgent,
            birthDate = usersItemDTO?.birthDate,
            crypto = mapResponseToDomain(cryptoDTO = usersItemDTO?.cryptoDTO),
            firstName = usersItemDTO?.firstName,
            macAddress = usersItemDTO?.macAddress,
            phone = usersItemDTO?.phone,
            age = usersItemDTO?.age,
            username = usersItemDTO?.username
        )
    }

    private fun mapResponseToDomain(hairDTO: HairDTO?): Hair {
        return Hair(
            color = hairDTO?.color,
            type = hairDTO?.type
        )
    }

    private fun mapResponseToDomain(bankDTO: BankDTO?): Bank {
        return Bank(
            iban = bankDTO?.iban,
            cardExpire = bankDTO?.cardExpire,
            cardType = bankDTO?.cardType,
            currency = bankDTO?.currency,
            cardNumber = bankDTO?.cardNumber
        )
    }

    private fun mapResponseToDomain(companyDTO: CompanyDTO?): Company {
        return Company(
            address = mapResponseToDomain(addressDTO = companyDTO?.addressDTO),
            name = companyDTO?.name,
            department = companyDTO?.department,
            title = companyDTO?.title
        )
    }

    private fun mapResponseToDomain(addressDTO: AddressDTO?): Address {
        return Address(
            country = addressDTO?.country,
            address = addressDTO?.address,
            city = addressDTO?.city,
            postalCode = addressDTO?.postalCode,
            coordinates = mapResponseToDomain(coordinatesDTO = addressDTO?.coordinatesDTO),
            stateCode = addressDTO?.stateCode,
            state = addressDTO?.state
        )
    }

    private fun mapResponseToDomain(coordinatesDTO: CoordinatesDTO?): Coordinates {
        return Coordinates(
            lng = coordinatesDTO?.lng,
            lat = coordinatesDTO?.lat
        )
    }

    private fun mapResponseToDomain(cryptoDTO: CryptoDTO?): Crypto {
        return Crypto(
            wallet = cryptoDTO?.wallet,
            coin = cryptoDTO?.coin,
            network = cryptoDTO?.network
        )
    }
}