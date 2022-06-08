package com.company;

import com.company.old.DataBase;
import com.company.old.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User("John", new DataBase());

    @Test
    void getName() {
        assertEquals("John", user.getName());
    }

    @Test
    void testToString() {
        assertEquals("Name: John",user.toString());
    }
}
