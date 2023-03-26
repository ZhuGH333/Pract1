package dadm.zyang.practica1.data.newquotation.model

import dadm.zyang.practica1.domain.model.Quotation
import retrofit2.Response
import java.io.IOException

fun QuotationDto.toDomain() =
    Quotation(id = quoteLink, cita = quoteText, author = quoteAuthor)

fun Response<QuotationDto>.toDomain() =
    if (isSuccessful) Result.success((body() as QuotationDto).toDomain())
    else Result.failure(IOException())
