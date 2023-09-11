package com.moviebookingapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviebookingapp.model.User;
import com.moviebookingapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    UserService userService;

    @Test
    void addUser() throws Exception {
        User user = new User();
        user.setId(0);
        user.setEmail("test@test.com");
        user.setLoginid("testing123");
        user.setFirstname("Test");
        user.setLastname("Test");
        user.setPassword("Test123");
        user.setConfirmpassword("Test123");
        user.setContactno("0000000000");
        user.setRole("User");

        when(userService.addUser(any(User.class))).thenReturn(user);

        ResultActions resultActions = mockMvc.perform(post("/api/v1.0/moviebooking/register").content(objectMapper.writeValueAsString(user)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        String actualResponse = resultActions.andReturn().getResponse().getContentAsString();
        assertEquals("Registration is done successfully...", actualResponse);
    }


    @Test
    void validateUser() throws Exception {
        User user = new User();
        user.setId(0);
        user.setEmail("test@test.com");
        user.setLoginid("testing123");
        user.setFirstname("Test");
        user.setLastname("Test");
        user.setPassword("Test123");
        user.setConfirmpassword("Test123");
        user.setContactno("0000000000");
        user.setRole("User");

        when(userService.validateUser(anyString(), anyString())).thenReturn(user);
        mockMvc.perform(post("/api/v1.0/moviebooking/login").param("loginid", "testing123").param("password", "Test123"))
                .andExpect(status().isOk());
    }

    @Test
    void passwordReset() {

    }
}