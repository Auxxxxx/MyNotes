package com.example.mynotes.di

import android.app.Application
import androidx.room.Room
import com.example.mynotes.feature.note.data.repository.NoteRepositoryImpl
import com.example.mynotes.feature.note.data.source.NoteDatabase
import com.example.mynotes.feature.note.domain.repository.NoteRepository
import com.example.mynotes.feature.note.domain.use_case.note.AddNote
import com.example.mynotes.feature.note.domain.use_case.note.DeleteNote
import com.example.mynotes.feature.note.domain.use_case.note.GetNote
import com.example.mynotes.feature.note.domain.use_case.note.GetNotes
import com.example.mynotes.feature.note.domain.use_case.note.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            addNote = AddNote(repository),
            deleteNote = DeleteNote(repository),
            getNote = GetNote(repository)
        )
    }
 }