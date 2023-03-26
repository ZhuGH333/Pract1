package dadm.zyang.practica1.data.favourites.model

import dadm.zyang.practica1.domain.model.Quotation

fun QuotationDto.toDomainModel() =
     Quotation(id=id, cita=cita, author=author)


fun Quotation.toDto() = QuotationDto(id=id, cita=cita, author=author)
