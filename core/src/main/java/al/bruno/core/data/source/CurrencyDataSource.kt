package al.bruno.core.data.source

import al.bruno.core.data.source.model.Currency
import retrofit2.Response

interface CurrencyDataSource {
    suspend fun currencies() : Response<List<Currency>>
}