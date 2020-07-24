package tacos

import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.view
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import kotlin.Exception

@ExtendWith(SpringExtension::class)
@WebMvcTest(HomeController::class)
class HomeControllerTest {

    @Autowired
    private val mockMvc: MockMvc ?= null

    @Test
    @Throws(Exception::class)
    fun testHomePage() {
        mockMvc!!.perform(get("/"))
                .andExpect(status().isOk)
                .andExpect(view().name("home"))
                .andExpect(content().string(
                        Matchers.containsString("Welcome to...")
                ))
    }
}