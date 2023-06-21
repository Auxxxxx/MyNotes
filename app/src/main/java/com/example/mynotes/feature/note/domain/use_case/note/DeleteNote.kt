package com.example.mynotes.feature.note.domain.use_case.note

import com.example.mynotes.feature.note.domain.model.Note
import com.example.mynotes.feature.note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}