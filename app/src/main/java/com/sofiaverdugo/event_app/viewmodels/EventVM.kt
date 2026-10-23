package com.sofiaverdugo.event_app.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sofiaverdugo.event_app.models.Event
import com.sofiaverdugo.event_app.models.EventRepo

class EventVM(
    private val repo: EventRepo
) : ViewModel() {
    private val _events = mutableStateOf<List<Event>>(emptyList())
    val events: State<List<Event>> = _events
    init {
        loadEvents()
    }
    private fun loadEvents() {
        _events.value = repo.getEvents()
    }


    fun setLike(eventId: Int) {
        _events.value = _events.value.map { event ->
            if (event.id == eventId) {
                event.copy(hasLiked = !event.hasLiked)
            } else {
                event
            }
        }
    }

    fun setInterested(eventId: Int) {
        _events.value = _events.value.map { event ->
            if (event.id == eventId) {
                event.copy(isInterested = !event.isInterested)
            } else {
                event
            }
        }
    }
}