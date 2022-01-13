package com.han.oose.rental.data.services;

import com.han.oose.rental.data.Contract;
import com.han.oose.rental.data.User;
import com.han.oose.rental.data.repositories.UserRepository;
import com.han.oose.rental.domain.interfaces.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    private final UserService sut = new UserServiceImpl();
    private UserRepository userRepository;
    private User user1;
    private User newUser;

    @BeforeEach
    public void setup() {
        userRepository = mock(UserRepository.class);
        sut.setUserRepository(userRepository);

        List<Contract> contracts = new ArrayList<Contract>();
        contracts.add(new Contract());
        final int USER_ID = 1;
        user1 = new User(USER_ID, "user1@gmail.com", "AONDUEnfsdocma12342asdfas  ", new Date(1999), new Date(2020), contracts);
        newUser = new User(2, "newUser@gmail.com", "AONDUEnfsdocma12342asdfas  ", new Date(1999), new Date(2020), contracts);
        when(sut.findById(USER_ID)).thenReturn(Optional.of(user1));
    }

    @Test
    void findMockedUserById(){

        Optional<User> users = sut.findById(user1.getId());
        User user2 = users.get();

        assertEquals(user1.getId(), user2.getId());
    }

    @Test
    void isUpdateCalled(){
        sut.update(newUser);

        verify(userRepository, times(1)).saveAndFlush(newUser);
    }
}
