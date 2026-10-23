package com.sofiaverdugo.event_app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sofiaverdugo.event_app.models.EventRepo

class EventVMFactory(
    private val repo: EventRepo
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventVM::class.java)) {
            return EventVM(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}