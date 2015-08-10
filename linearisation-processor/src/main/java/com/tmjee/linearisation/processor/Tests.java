package com.tmjee.linearisation.processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @author tmjee
 */
public class Tests {

    private static final String TESTS_LOCATION = "/META-INF/tests";

    private static volatile Map<String, Test> tests;

    public static Map<String, Test> getAll() {
        Map<String, Test> m = tests;
        if (m == null) {

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(Test.class.getResourceAsStream(TESTS_LOCATION)))) {
                String line = reader.readLine();
                if (line != null && !line.trim().isEmpty()) {
                    String[] segments = line.split(":::");
                    String n = segments[0];
                    String description = segments[1];
                    String runner = segments[2];
                    int playerCount = Integer.parseInt(segments[3]);

                    //tests.put(n, new Test(n, description, runner, playerCount));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            tests = m;
        }
        return tests;
    }



}
