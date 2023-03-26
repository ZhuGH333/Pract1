package dadm.zyang.practica1.data.newquotation

import dadm.zyang.practica1.domain.model.Quotation
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject constructor() : NewQuotationDataSource {

    override suspend fun getQuotation(): Result<Quotation> {
        return if (Math.random() < 0.9) {
            val num = (0..99).random().toString()
            val quotation = Quotation(num, "Quotation text #$num", "Author #$num")
            Result.success(quotation)

        } else {
            // Simula un error el 10% de las veces
            Result.failure(Exception())
        }
    }
}