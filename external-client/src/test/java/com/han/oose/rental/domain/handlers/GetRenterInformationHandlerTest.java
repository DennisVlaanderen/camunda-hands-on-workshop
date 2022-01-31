package com.han.oose.rental.domain.handlers;

import com.han.oose.rental.data.User;
import com.han.oose.rental.domain.interfaces.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class GetRenterInformationHandlerTest {

    private GetRenterInformationHandlerImpl sut;

    @BeforeEach
    public void setup(){
        sut = new GetRenterInformationHandlerImpl();
    }

    @Test
    public void whenAnUserIsFoundWithGetRenterInfoThenReturnARenterPOJOWithVerifiedTrue() {
        int USERID = 1;

        User user = mock(User.class);
        UserService userService = mock(UserService.class);
        sut.setUserService(userService);

        when(userService.findById(USERID)).thenReturn(Optional.of(user));
        when(user.isVerified()).thenReturn(true);

        assertTrue(sut.getRenterInfo(USERID).isVerified());
    }
}
