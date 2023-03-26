package dadm.zyang.practica1.data.settings

import dadm.zyang.practica1.domain.model.Quotation


interface NewQuotationManager {
    suspend fun getNewQuotation(): Result<Quotation>
}