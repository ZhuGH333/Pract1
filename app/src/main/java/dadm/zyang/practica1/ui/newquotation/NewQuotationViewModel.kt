package dadm.zyang.practica1.ui.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import dadm.zyang.practica1.domain.model.Quotation

class NewQuotationViewModel: ViewModel(){
    private val _userName = MutableLiveData<String>(getUserName())
    private fun getUserName()=setOf("Alice", "Bob","Charlie", "David", "Emma").random()
    val userName : LiveData<String> = _userName

    private val _cita = MutableLiveData<Quotation>()
    val cita : LiveData<Quotation> = _cita

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing : LiveData<Boolean> = _isRefreshing

    val isGreetingsVisible = Transformations.map(cita) { it == null }

    fun getNewQuotation(){
        _isRefreshing.value = true
        val num = (0..99).random().toString()
        _cita.value = Quotation(num, "Quotation text #$num", "Author #$num")
        _isRefreshing.value = false
    }
}