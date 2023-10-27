package com.example.co_opt3_fughetabout_it_inc.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Card
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val noteList = listOf(
                Note("Note 1", "This is the content of Note 1"),
                Note("Note 2", "This is the content of Note 2"),
                Note("Note 3", "This is the content of Note 3"),
                Note("Note 1", "This is the content of Note 1"),
                Note("Note 2", "This is the content of Note 2"),
                Note("Note 3", "This is the content of Note 3")
            )

            WearableNotesApp(noteList)
        }
    }
}

data class Note(val title: String, val content: String)

@Composable
fun NoteItem(note: Note) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    onClick = { print("meow") }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.body1,
            )
            Text(
                text = note.content,
                style = MaterialTheme.typography.body2,
            )
        }
    }
}

@Composable
fun WearableNotesApp(notes: List<Note>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(notes) { note ->
                NoteItem(note)
            }
        }
    }
}