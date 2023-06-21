package com.example.mynotes.feature.note.presentation.notes

import com.example.mynotes.feature.note.domain.model.Note
import com.example.mynotes.feature.note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}