package com.example.dayzee.book

import BookRepository
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dayzee.api.Books
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class BookViewModel:ViewModel() {
    var list = mutableStateListOf<Books>()
    var repository =BookRepository()
init{
    getBooks()
}
    fun getBooks(){
        viewModelScope.launch {
            var list1 = repository.getBooks()
         list.addAll(list1)
            println(list1)

        }

    }
}