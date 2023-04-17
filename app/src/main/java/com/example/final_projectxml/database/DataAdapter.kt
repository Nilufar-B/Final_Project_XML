package com.example.final_projectxml.database

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.final_projectxml.R
import com.example.final_projectxml.databinding.DataBinding

class DataAdapter(private val data: ArrayList<UserDataEntity>,
                  private val updateListener:(id:Int) -> Unit,
                  private val deleteListener:(id:Int) -> Unit

): RecyclerView.Adapter<DataAdapter.ViewHolder>() {


    class ViewHolder(binding: DataBinding) : RecyclerView.ViewHolder(binding.root){
        val llMain = binding.llMain
        val tvWeightDaily = binding.tvWeightDaily
        val tvCalories = binding.tvCalories
        val tvSteps = binding.tvSteps
        val ivEdit = binding.ivEdit
        val ivDelete = binding.ivDelete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        val data = data[position]

        holder.tvWeightDaily.text = data.weight.toString()
        holder.tvCalories.text = data.calories.toString()
        holder.tvSteps.text = data.steps.toString()

        if (position % 2 == 0){
            holder.llMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,
            R.color.LightGrey))
        }else{
            holder.llMain.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        }

        holder.ivEdit.setOnClickListener{
            updateListener.invoke(data.id)
        }

        holder.ivDelete.setOnClickListener{
            deleteListener.invoke(data.id)
        }
    }
}