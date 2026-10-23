package com.sofiaverdugo.event_app.models

import java.time.LocalDateTime
import kotlin.inc

data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val location: String,
    val dateTime: LocalDateTime,
    val cost: String,
    val registerLink: String,
    var peopleInterested: Int,
    var isInterested: Boolean = false,
    var likes: Int,
    var hasLiked: Boolean = false,
    val photo: Int
)
{
    fun setInterested() {
        if (!isInterested) {
            peopleInterested++
            isInterested = true
        }
    }

    fun setLike() {
        if (!hasLiked) {
            likes++
            hasLiked = true
        }
    }
}

