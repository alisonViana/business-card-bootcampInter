package br.com.dio.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.businesscard.R
import br.com.dio.businesscard.data.BusinessCard

class BusinessCardAdapter:
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallBack()) {

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_business_card, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder( itemView: View ): RecyclerView.ViewHolder(itemView){
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        private val tvEmail: TextView = itemView.findViewById(R.id.tv_email)
        private val tvCompany: TextView = itemView.findViewById(R.id.tv_company)
        private val cardContent: CardView = itemView.findViewById(R.id.card_content)

        fun bind(item: BusinessCard){
            tvName.text = item.name
            tvPhone.text = item.phone
            tvEmail.text = item.email
            tvCompany.text = item.company
            cardContent.setCardBackgroundColor(Color.parseColor(item.backgroundColor))
            cardContent.setOnClickListener {
                listenerShare(it)
            }
        }
    }
}

class DiffCallBack : DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard): Boolean = oldItem.id == newItem.id

}