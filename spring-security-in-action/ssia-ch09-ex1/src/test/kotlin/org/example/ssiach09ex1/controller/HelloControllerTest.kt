package org.example.ssiach09ex1.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun hello() {
        mvc.perform(get("/hello").header("Authorization", "key"))
            .andExpect(status().isOk)
    }

    @Test
    fun helloFail() {
        mvc.perform(get("/hello"))
            .andExpect(status().is4xxClientError)
    }
}