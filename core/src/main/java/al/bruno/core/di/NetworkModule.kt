package al.bruno.core.di

import al.bruno.core.BuildConfig
import al.bruno.core.data.source.remote.service.*
import al.bruno.core.interceptor.AuthorizationInterceptor
import al.bruno.core.interceptor.RefreshTokenInterceptor
import al.bruno.core.error.ErrorHandler
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun okHttpClient(
        authorizationInterceptor: AuthorizationInterceptor,
        refreshTokenInterceptor: RefreshTokenInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(refreshTokenInterceptor)
            .addInterceptor(authorizationInterceptor)
            .build()
    }

    @Provides
    @Reusable
    fun errorHandler(retrofit: Retrofit): ErrorHandler = ErrorHandler(retrofit)

    @Provides
    @Reusable
    fun logging(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Reusable
    fun converterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create(
            Moshi
                .Builder()
                .build()
        )
    }

    @Provides
    @Singleton
    fun baseUrl(): String = BuildConfig.HOST_NAME

    @Provides
    @Reusable
    fun providerRetrofit(
        baseUrl: String,
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    @Provides
    @Reusable
    fun propertyService(retrofit: Retrofit): PropertyService = retrofit.create(PropertyService::class.java)


    @Provides
    @Reusable
    fun cityService(retrofit: Retrofit): CityService = retrofit.create(CityService::class.java)

    @Provides
    @Reusable
    fun currencyService(retrofit: Retrofit): CurrencyService = retrofit.create(CurrencyService::class.java)


    @Provides
    @Reusable
    fun floorPlanService(retrofit: Retrofit): FloorPlanService = retrofit.create(FloorPlanService::class.java)


    @Provides
    @Reusable
    fun operationService(retrofit: Retrofit): OperationService = retrofit.create(OperationService::class.java)


    @Provides
    @Reusable
    fun propertyTypeService(retrofit: Retrofit): PropertyTypeService = retrofit.create(PropertyTypeService::class.java)

    @Provides
    @Reusable
    fun unitService(retrofit: Retrofit): UnitService = retrofit.create(UnitService::class.java)


    @Provides
    @Reusable
    fun authorityService(retrofit: Retrofit): AuthorityService = retrofit.create(AuthorityService::class.java)

    @Provides
    @Reusable
    fun authorityRequestAccountService(retrofit: Retrofit): RequestAccountService = retrofit.create(RequestAccountService::class.java)

    @Provides
    @Reusable
    fun authorityUserService(retrofit: Retrofit): UserService = retrofit.create(UserService::class.java)
}