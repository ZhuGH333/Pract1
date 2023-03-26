package dadm.zyang.practica1.data.newquotation

import dadm.zyang.practica1.domain.model.Quotation
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor() : NewQuotationRepository {

    override suspend fun getNewQuotation(): Result<Quotation> {
        if (Math.random() < 0.9) {
            for (i in 0..19) {
                val num = (0..99).random().toString()
                Result.success(Quotation(num, "Quotation text #$num", "Author #$num"))
            }
        } else {
            // Simula un error el 10% de las veces
            Result.failure<Exception>(Exception("Error al obtener la cita"))
        }
    }
}