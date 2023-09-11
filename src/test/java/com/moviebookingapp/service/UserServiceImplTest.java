package com.moviebookingapp.service;

import com.moviebookingapp.model.User;
import com.moviebookingapp.pojo.PasswordRequest;
import com.moviebookingapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private SequenceGeneratorService sequenceGeneratorService;

    @InjectMocks
    UserServiceImpl service;

    @Test
    void addUserTestForSuccess() throws Exception {
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

        when(userRepository.findByLoginid(anyString())).thenReturn(null);
        when(sequenceGeneratorService.generateSequence(anyString())).thenReturn(0L);
        when(userRepository.save(any(User.class))).thenReturn(user);


        User response = service.addUser(user);
        assertNotNull(response);
        assertEquals(0, response.getId());
        assertEquals("test@test.com", response.getEmail());
        assertEquals("testing123", response.getLoginid());
        assertEquals("Test", response.getFirstname());
        assertEquals("Test", response.getLastname());
        assertEquals("Test123", response.getPassword());
        assertEquals("Test123", response.getConfirmpassword());
        assertEquals("0000000000", response.getContactno());
        assertEquals("User", response.getRole());

    }

    @Test
    void addUserTestForException() throws Exception {
        User user = new User();
        user.setId(0);
        user.setEmail("test@test.com");
        user.setLoginid("testing123");
        user.setFirstname("Test");
        user.setLastname("Test");
        user.setPassword("Test123");
        user.setConfirmpassword("Test1234");
        user.setContactno("0000000000");
        user.setRole("User");

        when(userRepository.findByLoginid(anyString())).thenReturn(null);

        assertThrows(Exception.class, () -> {
            service.addUser(user);
        });

    }

    @Test
    void validateUser() {
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
        when(userRepository.findByLoginidAndPassword(anyString(), anyString())).thenReturn(user);

        User response = service.validateUser("testing123", "Test123");
        assertNotNull(response);
        assertEquals(0, response.getId());
        assertEquals("test@test.com", response.getEmail());
        assertEquals("testing123", response.getLoginid());
        assertEquals("Test", response.getFirstname());
        assertEquals("Test", response.getLastname());
        assertEquals("Test123", response.getPassword());
        assertEquals("Test123", response.getConfirmpassword());
        assertEquals("0000000000", response.getContactno());
        assertEquals("User", response.getRole());

    }

    @Test
    void passwordReset() throws Exception {
        PasswordRequest passwordRequest = new PasswordRequest();
        passwordRequest.setLoginid("Testing123");
        passwordRequest.setPassword("Tst12345");
        passwordRequest.setConfirmpassword("Tst12345");

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

        when(userRepository.findByLoginid(anyString())).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);

        assertTrue(service.passwordReset(passwordRequest));
    }
}