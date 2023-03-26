package dadm.zyang.practica1.data.newquotation

import dadm.zyang.practica1.domain.model.Quotation

interface NewQuotationRepository {

    suspend fun getNewQuotation(): Result<Quotation>

}