package com.example.dayzee.book

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.gson.Gson


@Composable
fun Book(navController: NavHostController) {
    val viewModel: BookViewModel = viewModel()
    println("@@@"+viewModel.list)
//    viewModel.getBooks()
    LazyColumn{
        items(viewModel.list){
            Column(modifier = Modifier.clickable {
                val json = Uri.encode(Gson().toJson(it))
//                %7B%22author%22%3A%222131230905%22%2C%22description%22%3A%222131230906%22%2C%22id%22%3A846%2C%22published%22%3A2131230908%2C%22title%22%3A%222131230909%22%7D
println("json $json")
                navController.navigate("two/${json}") }){
                Text(it.author)
                Text(it.id.toString())
            }
        }
    }

}
