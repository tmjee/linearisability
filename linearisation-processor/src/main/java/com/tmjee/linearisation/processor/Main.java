package com.tmjee.linearisation.processor;

/**
 * @author tmjee
 */
public class Main {

    public static void main(String[] arguments) throws Exception {

        Arguments args = Arguments.parse(arguments);

        if (args != null) {
            new Linearisation().run(args);
        }
    }
}
