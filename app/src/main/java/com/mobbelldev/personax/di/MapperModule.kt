package com.mobbelldev.personax.di

import com.mobbelldev.personax.data.mapper.AddressMapper
import com.mobbelldev.personax.data.mapper.BankMapper
import com.mobbelldev.personax.data.mapper.CompanyMapper
import com.mobbelldev.personax.data.mapper.CoordinatesMapper
import com.mobbelldev.personax.data.mapper.CryptoMapper
import com.mobbelldev.personax.data.mapper.FavoriteUserMapper
import com.mobbelldev.personax.data.mapper.HairMapper
import com.mobbelldev.personax.data.mapper.UserResponseMapper
import com.mobbelldev.personax.data.mapper.UsersItemMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Provides
    fun provideHairMapper() = HairMapper()

    @Provides
    fun provideBankMapper() = BankMapper()

    @Provides
    fun provideCryptoMapper() = CryptoMapper()

    @Provides
    fun provideCoordinatesMapper() = CoordinatesMapper()

    @Provides
    fun provideAddressMapper(coordinatesMapper: CoordinatesMapper) =
        AddressMapper(coordinatesMapper)

    @Provides
    fun provideCompanyMapper(addressMapper: AddressMapper) =
        CompanyMapper(addressMapper)

    @Provides
    fun provideUsersItemMapper(
        hairMapper: HairMapper,
        bankMapper: BankMapper,
        companyMapper: CompanyMapper,
        addressMapper: AddressMapper,
        cryptoMapper: CryptoMapper
    ) = UsersItemMapper(hairMapper, bankMapper, companyMapper, addressMapper, cryptoMapper)

    @Provides
    fun provideUserResponseMapper(usersItemMapper: UsersItemMapper) =
        UserResponseMapper(usersItemMapper)

    @Provides
    fun provideFavoriteUserMapper() = FavoriteUserMapper()
}