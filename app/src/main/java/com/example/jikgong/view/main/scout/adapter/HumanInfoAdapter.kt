package com.example.jikgong.view.main.scout.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.jikgong.R
import com.example.jikgong.view.main.scout.dataModel.HumanInfoItem

class HumanInfoAdapter(private val myDataset: Array<HumanInfoItem>) :
    RecyclerView.Adapter<HumanInfoAdapter.MyViewHolder>() {

    class MyViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): HumanInfoAdapter.MyViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_reccycle_scout_human_info, parent, false) as ConstraintLayout
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageView1 = holder.layout.findViewById<ImageView>(R.id.imageView4)
        imageView1.setImageResource(myDataset[position].imageResourceId)

        val name1 = holder.layout.findViewById<ImageView>(R.id.textView11)
        name1.setImageResource(myDataset[position].imageResourceId)

        val ageGenExp1 = holder.layout.findViewById<ImageView>(R.id.textView12)
        ageGenExp1.setImageResource(myDataset[position].imageResourceId)

        val description1 = holder.layout.findViewById<ImageView>(R.id.textView20)
        description1.setImageResource(myDataset[position].imageResourceId)

        val count1 = holder.layout.findViewById<ImageView>(R.id.textView21)
        count1.setImageResource(myDataset[position].imageResourceId)

        val participationRate1 = holder.layout.findViewById<ImageView>(R.id.textView22)
        participationRate1.setImageResource(myDataset[position].imageResourceId)

        val time1 = holder.layout.findViewById<ImageView>(R.id.textView24)
        time1.setImageResource(myDataset[position].imageResourceId)
    }

    override fun getItemCount() = myDataset.size
}