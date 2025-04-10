package com.mobbelldev.personax.data.mapper

import com.mobbelldev.personax.data.source.remote.model.UsersItemDTO
import com.mobbelldev.personax.domain.model.UsersItem
import javax.inject.Inject

class UsersItemMapper @Inject constructor(
    private val hairMapper: HairMapper,
    private val bankMapper: BankMapper,
    private val companyMapper: CompanyMapper,
    private val addressMapper: AddressMapper,
    private val cryptoMapper: CryptoMapper,
) {
    fun map(usersItemDTO: UsersItemDTO?): UsersItem {
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
            hair = hairMapper.map(
                dto = usersItemDTO?.hairDTO
            ),
            bank = bankMapper.map(
                dto = usersItemDTO?.bankDTO
            ),
            eyeColor = usersItemDTO?.eyeColor,
            company = companyMapper.map(
                dto = usersItemDTO?.companyDTO
            ),
            id = usersItemDTO?.id,
            email = usersItemDTO?.email,
            height = usersItemDTO?.height,
            image = usersItemDTO?.image,
            address = addressMapper.map(
                dto = usersItemDTO?.addressDTO
            ),
            ip = usersItemDTO?.ip,
            weight = usersItemDTO?.weight,
            userAgent = usersItemDTO?.userAgent,
            birthDate = usersItemDTO?.birthDate,
            crypto = cryptoMapper.map(
                dto = usersItemDTO?.cryptoDTO
            ),
            firstName = usersItemDTO?.firstName,
            macAddress = usersItemDTO?.macAddress,
            phone = usersItemDTO?.phone,
            age = usersItemDTO?.age,
            username = usersItemDTO?.username,
            isFavorite = false
        )
    }
}