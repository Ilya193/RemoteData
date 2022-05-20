import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PostsServiceTest {
    @Test
    fun test_fetch_data() {
        val expected = StringBuilder("data")

        val service = object : PostsService {
            override fun fetchPosts(): StringBuilder {
                return expected
            }
        }

        assertEquals(expected, service.fetchPosts())
    }
}