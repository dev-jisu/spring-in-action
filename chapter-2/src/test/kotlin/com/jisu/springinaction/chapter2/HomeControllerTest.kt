package com.jisu.springinaction.chapter2

import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.hamcrest.Matchers.containsString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content

import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.springframework.test.web.servlet.result.MockMvcResultMatchers.view


@WebMvcTest
class HomeControllerTest() {

    @Autowired
    private lateinit var mockMvc:MockMvc

    @Test
    fun testHomePage(){
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"))
            .andExpect(content().string(containsString("Welcome")))
    }


}