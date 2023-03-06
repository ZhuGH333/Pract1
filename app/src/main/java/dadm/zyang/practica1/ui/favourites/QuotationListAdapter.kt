package dadm.zyang.practica1.ui.favourites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dadm.zyang.practica1.databinding.QuotationItemBinding
import dadm.zyang.practica1.domain.model.Quotation

class QuotationListAdapter:ListAdapter<Quotation, QuotationListAdapter.ViewHolder>(QuotationDiff){

    class ViewHolder(qiBind: QuotationItemBinding): RecyclerView.ViewHolder(qiBind.root){
        fun bind(quotation: Quotation){
            val binding = QuotationItemBinding.bind(itemView)
            binding.mtvQuotation.text = quotation.cita
            binding.mtvAuthor.text = quotation.author
        }
    }

    object QuotationDiff: DiffUtil.ItemCallback<Quotation>(){
        override fun areItemsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = QuotationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}