package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.data.source.model.Currency
import al.bruno.core.data.source.remote.CurrencyRemoteDataSource
import javax.inject.Inject

class CurrencyRepository @Inject constructor(private val currencyDataSource: CurrencyRemoteDataSource) {
    suspend fun currencies() : Result<List<Currency>> {
        return try {
            val response = currencyDataSource.currencies()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.Success(body)
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }
}