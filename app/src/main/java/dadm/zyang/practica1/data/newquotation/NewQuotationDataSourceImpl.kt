package dadm.zyang.practica1.data.newquotation

import dadm.zyang.practica1.data.newquotation.model.QuotationDto
import dadm.zyang.practica1.data.newquotation.model.toDomain
import dadm.zyang.practica1.domain.model.Quotation
import okhttp3.MediaType
import retrofit2.Response
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject


class NewQuotationDataSourceImpl @Inject constructor(private val retrofit: Retrofit) : NewQuotationDataSource {

    private val retrofitQuotationService = retrofit.create(NewQuotationRetrofit::class.java)
    interface NewQuotationRetrofit {
        @GET("api/1.0/?method=getQuote&format=json")
        suspend fun getQuotation( @Query("lang") lang: String): Response<QuotationDto>
    }
    override suspend fun getQuotation( lang: String): Response<QuotationDto> {
        return try {
            retrofitQuotationService.getQuotation(lang)
        } catch (e: Exception) {
            Response.error(
                400, // Could be any other code and text, because we are not using it
                ResponseBody.create(MediaType.parse("text/plain"), e.toString())
            )
        }
    }
}