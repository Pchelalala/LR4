package com.company;

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
