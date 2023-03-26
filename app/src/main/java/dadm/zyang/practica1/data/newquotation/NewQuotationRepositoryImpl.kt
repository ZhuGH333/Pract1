package dadm.zyang.practica1.data.newquotation

import dadm.zyang.practica1.data.newquotation.model.toDomain
import dadm.zyang.practica1.domain.model.Quotation
import dadm.zyang.practica1.utils.NoInternetException
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor(private val dataSource: NewQuotationDataSource,
                                                     private val connectivityChecker: ConnectivityChecker
) : NewQuotationRepository {
    override suspend fun getNewQuotation(): Result<Quotation> {
        if (connectivityChecker.isConnectionAvailable()) {
            return dataSource.getQuotation(arrayOf("en", "ru", "xx").random()).toDomain()
        } else {
            return Result.failure(NoInternetException())
        }
    }
}