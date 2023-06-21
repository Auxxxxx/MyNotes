package com.example.mynotes.feature.note.domain.use_case.note

import com.example.mynotes.feature.note.domain.model.InvalidNoteException
import com.example.mynotes.feature.note.domain.model.Note
import com.example.mynotes.feature.note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note cannot be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note cannot be empty")
        }
        repository.addNote(note)
    }
}