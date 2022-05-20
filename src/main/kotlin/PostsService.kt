import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

//unit test PostsServiceTest.kt
interface PostsService {
    fun fetchPosts(): StringBuilder

    class Base : PostsService {
        override fun fetchPosts(): StringBuilder {
            val url = URL("https://jsonplaceholder.typicode.com/posts")
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            val content = StringBuilder()

            try {
                BufferedReader(InputStreamReader(connection.inputStream)).use { input ->
                    var line: String?
                    while (input.readLine().also { line = it } != null) {
                        content.append(line)
                        content.append(System.lineSeparator())
                    }
                }
            } finally {
                connection.disconnect()
            }

            return content
        }
    }
}