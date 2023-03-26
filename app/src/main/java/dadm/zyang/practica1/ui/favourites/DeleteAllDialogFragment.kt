package dadm.zyang.practica1.ui.favourites

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import dadm.zyang.practica1.R

class DeleteAllDialogFragment( private val listener: DeleteAllDialogListener) : DialogFragment() {

    interface DeleteAllDialogListener {
        fun onDeleteAllConfirmed()
        fun onDeleteAllCancelled()
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(R.string.titleDeleteAll)
        builder.setMessage(R.string.msgDeleteAll)
        builder.setPositiveButton(R.string.botoDialogPositive) { _, _ ->
            listener.onDeleteAllConfirmed()
        }
        builder.setNegativeButton(R.string.botoDialogNegative) { _, _ ->
            listener.onDeleteAllCancelled()
        }
        return builder.create()
    }
}
