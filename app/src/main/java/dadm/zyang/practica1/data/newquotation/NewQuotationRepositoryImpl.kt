package dadm.zyang.practica1.data.newquotation

import dadm.zyang.practica1.domain.model.Quotation
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor(private val newQuotationDataSourceImpl: NewQuotationDataSourceImpl) : NewQuotationRepository {

    override suspend fun getNewQuotation(): Result<Quotation> {
        return newQuotationDataSourceImpl.getQuotation()
    }
}