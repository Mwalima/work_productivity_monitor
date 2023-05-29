package org.monitor;

import org.monitor.helper.InputCheker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class TestMonitorTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    public void whenMatchesTenDigitsNumber_thenCorrect() {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher("0606060606");
        assertTrue(matcher.matches());
    }

    public void whenMatchesTwoDigitsNumber_thenCorrect() {
        Pattern pattern = Pattern.compile("^\\d{2}$");
        Matcher matcher = pattern.matcher("22");
        assertTrue(matcher.matches());
    }

    public void whenMatchesSixCharcters_thenCorrect() {
        Pattern pattern = Pattern.compile("^\\a-z{6}$");
        Matcher matcher = pattern.matcher("1245AM");
        assertTrue(matcher.matches());
    }

    public void testUsingRFC5322Regex() {
        String emailAddress = "username@domain.com";
        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        assertTrue(InputCheker.patternMatches(emailAddress, regexPattern));
    }
}