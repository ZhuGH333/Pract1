package dadm.zyang.practica1.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import dadm.zyang.practica1.domain.model.Quotation

class FavouritesViewModel: ViewModel() {
    private val _listaFav = MutableLiveData<List<Quotation>>(getFavouritesQuotation())
    val listaFavs: LiveData<List<Quotation>> = _listaFav

    val isDeleteAllVisible = Transformations.map(listaFavs) { it.isNotEmpty() }


    private fun getFavouritesQuotation(): List<Quotation> {
        val lista = mutableListOf<Quotation>()
        for (i in 0..19) {
            val num = (0..99).random().toString()
            lista.add(Quotation(num, "Quotation text #$num", "Author #$num"))
        }
        return lista
    }
    fun deleteAllQuotation(){
        _listaFav.value = emptyList()
    }

}