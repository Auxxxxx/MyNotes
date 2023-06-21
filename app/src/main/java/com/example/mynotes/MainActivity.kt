package com.example.mynotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mynotes.feature.note.presentation.add_edit_note.AddEditNoteScreen
import com.example.mynotes.feature.note.presentation.add_edit_note.NOTE_COLOR_CREATE_NEW
import com.example.mynotes.feature.note.presentation.add_edit_note.NOTE_ID_CREATE_NEW
import com.example.mynotes.feature.note.presentation.notes.NotesScreen
import com.example.mynotes.feature.note.presentation.util.Screen
import com.example.mynotes.ui.Red
import com.example.mynotes.ui.theme.MyNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNotesTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NotesScreen.route
                    ) {
                        composable(route = Screen.NotesScreen.route) {
                            NotesScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditNoteScreen.route +
                                    "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = NOTE_ID_CREATE_NEW
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = NOTE_COLOR_CREATE_NEW
                                },
                            )
                        ) {
                            val color = it.arguments?.getInt("noteColor") ?: NOTE_COLOR_CREATE_NEW
                            AddEditNoteScreen(
                                navController = navController,
                                noteColor = color
                            )
                        }
                    }
                }
            }
        }
    }
}