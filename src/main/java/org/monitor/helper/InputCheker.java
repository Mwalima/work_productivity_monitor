package org.monitor.helper;

import java.util.regex.Pattern;

/**
 * The type Input cheker.
 */
public class InputCheker {

    /**
     * Pattern matches boolean.
     *
     * @param emailAddress the email address
     * @param regexPattern the regex pattern
     * @return the boolean
     */
    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
