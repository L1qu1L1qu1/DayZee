import com.example.dayzee.api.ApiHelper
import com.example.dayzee.api.BookApi
import com.example.dayzee.api.Books

class BookRepository{
    suspend fun getBooks(): List<Books> {
        var bookApi: BookApi = ApiHelper.createApiHelper()

        return  bookApi.getBooks()
    }
}
