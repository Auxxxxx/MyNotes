package com.example.mynotes.feature.note.data.repository

import com.example.mynotes.feature.note.data.source.NoteDao
import com.example.mynotes.feature.note.domain.model.Note
import com.example.mynotes.feature.note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getAll()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.findById(id)
    }

    override suspend fun addNote(note: Note) {
        return dao.save(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.delete(note)
    }
}