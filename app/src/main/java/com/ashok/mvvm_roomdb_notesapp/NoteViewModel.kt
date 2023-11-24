package com.ashok.mvvm_roomdb_notesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NoteViewModel(application: Application) : AndroidViewModel(application) {

     val dao = NoteDatabase.getDatabase(application).getNoteDao()
     val repository = NoteRepository(dao)
     var allNotes : LiveData<List<Note>> = repository.allNotes

     fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO){
          repository.delete(note)
     }

     fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO){
          repository.insert(note)
     }

}