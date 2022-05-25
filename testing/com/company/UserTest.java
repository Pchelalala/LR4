package com.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    @Test
    void createStatement(){


    }
}