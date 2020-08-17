package com.andreskaminker.expandablecardexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.andreskaminker.expandablecardexample.databinding.ActivityMainBinding
import com.andreskaminker.expandablecardexample.entities.Event
import com.andreskaminker.expandablecardexample.entities.EventAdapter

class MainActivity : AppCompatActivity() {
    val listOfEvents = mutableListOf<Event>(
            Event("Evento 1", "Este es el primer evento", "21-08-02"),
            Event("Evento 2", "Este es el segundo evento", "23-09-02"),
            Event("Evento 3", "Este es el tercer evento", "20-11-21")
            )

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerEvents.apply {
            layoutManager = LinearLayoutManager(context)
            adapter =  EventAdapter(listOfEvents, context)
            setHasFixedSize(true)
        }


    }
}