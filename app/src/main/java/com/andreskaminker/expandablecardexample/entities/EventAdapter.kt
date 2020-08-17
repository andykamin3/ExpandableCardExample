package com.andreskaminker.expandablecardexample.entities

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andreskaminker.expandablecardexample.R
import com.andreskaminker.expandablecardexample.databinding.ActivityMainBinding
import com.andreskaminker.expandablecardexample.databinding.ExpandableCardEventBinding

class EventAdapter(val eventList : MutableList<Event>, val context: Context) : RecyclerView.Adapter<EventAdapter.EventViewHolder>(){

    class EventViewHolder(val binding: ExpandableCardEventBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventAdapter.EventViewHolder {
        val binding = ExpandableCardEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun getItemCount(): Int = eventList.size

    override fun onBindViewHolder(holder: EventAdapter.EventViewHolder, position: Int) {
    val event = eventList[position]
            holder.binding.apply {
                cardTitle.text = event.name
                cardDescription.text = event.description
                cardDateTime.text = event.date

                expandButton.setOnClickListener{
                    var rotation = expandButton.rotation
                    if(cardDescription.visibility == View.VISIBLE && cardDateTime.visibility == View.VISIBLE){
                        cardDescription.visibility = View.GONE
                        cardDateTime.visibility = View.GONE
                        rotation -= 180
                    } else {
                        cardDescription.visibility = View.VISIBLE
                        cardDateTime.visibility = View.VISIBLE
                        rotation += 180
                    }
                    expandButton.rotation = rotation

                }
            }


    }
}