package com.nna.sklnabi.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nna.sklnabi.DetailActivity
import com.nna.sklnabi.databinding.ItemNabiBinding
import com.nna.sklnabi.databinding.ItemRasulBinding
import com.nna.sklnabi.model.ResponseItem

class AdapterRasul : RecyclerView.Adapter<AdapterRasul.ViewHolder>() {

    private val listData: ArrayList<ResponseItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(getData: List<ResponseItem>) {
        listData.clear()
        listData.addAll(getData)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemRasulBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRasulBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]

        holder.binding.tvJudul.text = data.nama
        holder.binding.tvTempat.text = data.tempat
        holder.binding.imgRasul.load(data.avatar)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DATA, data)

            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listData.size
}