package dadm.zyang.practica1.data.newquotation

import dadm.zyang.practica1.data.newquotation.model.QuotationDto
import dadm.zyang.practica1.domain.model.Quotation
import retrofit2.Response

interface NewQuotationDataSource {
    suspend fun getQuotation( lang: String ): Response<QuotationDto>
}