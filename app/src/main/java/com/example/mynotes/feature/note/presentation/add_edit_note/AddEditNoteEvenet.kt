package com.example.mynotes.feature.note.presentation.add_edit_note

import androidx.compose.ui.focus.FocusState

sealed class AddEditNoteEvenet {
    data class EnteredTitle(val value: String): AddEditNoteEvenet()
    data class ChangeTitleFocus(val focusState: FocusState): AddEditNoteEvenet()
    data class EnteredContent(val value: String): AddEditNoteEvenet()
    data class ChangeContentFocus(val focusState: FocusState): AddEditNoteEvenet()
    data class ChangeColor(val color: Int): AddEditNoteEvenet()
    object SaveNote: AddEditNoteEvenet()
}
