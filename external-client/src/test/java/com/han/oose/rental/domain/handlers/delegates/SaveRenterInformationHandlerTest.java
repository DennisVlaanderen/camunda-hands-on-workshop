package com.han.oose.rental.domain.handlers.delegates;

import com.han.oose.rental.data.Contract;
import com.han.oose.rental.data.User;
import com.han.oose.rental.domain.interfaces.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class SaveRenterInformationHandlerTest {

    private SaveRenterInformationHandlerImpl sut;

    @BeforeEach
    public void setup(){
        sut = new SaveRenterInformationHandlerImpl();
    }

    @Test
    public void ifSaveRenterIsCalledWithAnAvailableUserThenMakeSureUpdateIsCalled() {
        int USER_ID = 1;
        long DATE_LONG = 100;
        List<Contract> CONTRACTS = new ArrayList<>();
        Date DATE = new Date(DATE_LONG);

        UserService userService = mock(UserService.class);

        User user = new User(USER_ID,"", "", DATE, DATE, CONTRACTS);

        sut.setUserService(userService);

        when(userService.findById(USER_ID)).thenReturn(Optional.of(user));

        sut.saveRenterInformation(USER_ID, DATE_LONG, DATE_LONG);
        verify(userService, times(1)).update(user);
    }
}
