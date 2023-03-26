package dadm.zyang.practica1.data.newquotation

import dadm.zyang.practica1.domain.model.Quotation

interface NewQuotationDataSource {
    suspend fun getQuotation(): Result<Quotation>
}