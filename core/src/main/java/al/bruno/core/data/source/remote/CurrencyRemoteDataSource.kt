package al.bruno.core.data.source.remote

import al.bruno.core.data.source.CurrencyDataSource
import al.bruno.core.data.source.model.Currency
import al.bruno.core.data.source.remote.service.CurrencyService
import retrofit2.Response
import javax.inject.Inject

class CurrencyRemoteDataSource @Inject constructor(private val currencyService: CurrencyService) : CurrencyDataSource{
    override suspend fun currencies() : Response<List<Currency>> = currencyService.currencies()
}