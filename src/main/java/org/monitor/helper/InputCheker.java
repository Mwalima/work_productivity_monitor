package org.monitor.helper;

import java.util.regex.Pattern;

public class InputCheker {

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
