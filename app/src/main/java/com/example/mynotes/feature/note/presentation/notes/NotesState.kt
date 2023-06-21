package com.example.mynotes.feature.note.presentation.notes

import com.example.mynotes.feature.note.domain.model.Note
import com.example.mynotes.feature.note.domain.util.NoteOrder
import com.example.mynotes.feature.note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Ascending),
    val isOrderSectionVisible: Boolean = false
)
