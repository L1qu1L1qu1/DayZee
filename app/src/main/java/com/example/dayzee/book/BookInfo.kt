package com.example.dayzee.book



import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.dayzee.api.Books
import com.google.gson.Gson


@Composable
    fun bookInfo(navController: NavHostController, book: Books?) {
    println(book)
Column{
    Text(book!!.author)
    Text(book!!.title)
    Text(book!!.description)
    Text(book!!.author)
    Text(book!!.title)
    Text(book!!.description)
}
    }
