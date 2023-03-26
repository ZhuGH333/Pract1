package dadm.zyang.practica1.ui.favourites

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import dadm.zyang.practica1.R

class DeleteAllDialogFragment: DialogFragment() {

    private val viewModel: FavouritesViewModel by activityViewModels()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(R.string.titleDeleteAll)
        builder.setMessage(R.string.msgDeleteAll)
        builder.setPositiveButton(R.string.botoDialogPositive) { _, _ ->
            viewModel.deleteAllQuotation()
        }
        builder.setNegativeButton(R.string.botoDialogNegative) { _, _ ->
            dismiss()
        }
        return builder.create()
    }
}
