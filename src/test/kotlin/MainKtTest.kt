import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class MainKtTest {

    @Test
    fun add() {
        val post = Post(id = 1)
        val expected = 1
        WallService.add(post)
        val result = WallService.add(post).id

        assertEquals(expected, result)
    }

    @Test
    fun update_true() {
        val post1 = Post(id = 1)
        val post2 = Post(id = 1, text = "newText")
        WallService.add(post1)

        val result = WallService.update(post2)

        assertTrue(result)
    }

    @Test
    fun update_false() {
        val post1 = Post(id = 1)
        val post2 = Post(id = 14343, text = "newText")
        WallService.add(post1)

        val result = WallService.update(post2)

        assertFalse(result)
    }

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }
}



