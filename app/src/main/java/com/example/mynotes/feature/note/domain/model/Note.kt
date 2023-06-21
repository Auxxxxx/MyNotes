package com.example.mynotes.feature.note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mynotes.ui.Blue
import com.example.mynotes.ui.Purple
import com.example.mynotes.ui.Red
import com.example.mynotes.ui.Yellow
import java.time.LocalTime

@Entity
data class Note(
    val title: String,
    val content: String,
    val createdAt: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(Red, Yellow, Blue, Purple)
    }
}

class InvalidNoteException(message: String): Exception(message)