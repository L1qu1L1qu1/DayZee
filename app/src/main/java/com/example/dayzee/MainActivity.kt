package com.example.dayzee

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dayzee.api.Books
import com.example.dayzee.book.Book
import com.example.dayzee.book.bookInfo
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var navController = rememberNavController()
            NavHost(navController = navController, startDestination = "one"){

                composable("one"){ Book(navController)}
                composable("two/{book}", arguments = listOf(
                    navArgument("book") {
                        type = AccetParamType()
                    }
                )
                ){
//                    val bookName = it.arguments?.getString("bookName")
                    val book = it.arguments?.getParcelable<Books>("book")
                    bookInfo(navController, book)}
            }
//            var list = remember{ mutableListOf<Books>()}
//            var scope = rememberCoroutineScope()
//            scope.launch {
//            var bookApi: BookApi = ApiHelper.createApiHelper()
//                var listFromServer:List<Books> = bookApi.getBooks()
//                list.addAll(listFromServer)
//                println(listFromServer)
//            }
        }
    }
}
class AccetParamType():NavType<Books>(isNullableAllowed = false){
    override fun get(bundle: Bundle, key: String): Books? {
      return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Books {
      return Gson().fromJson(value, Books::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Books) {
         bundle.putParcelable(key, value)
    }

}



