package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.Currency
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyService {
    @GET("api/currencies")
    suspend fun currencies() : Response<List<Currency>>
}