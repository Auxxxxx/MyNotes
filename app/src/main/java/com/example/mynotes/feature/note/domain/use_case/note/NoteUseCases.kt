package com.example.mynotes.feature.note.domain.use_case.note

data class NoteUseCases(
    val getNotes: GetNotes,
    val addNote: AddNote,
    val deleteNote: DeleteNote,
    val getNote: GetNote
)