package com.tmjee.linearisation.processor;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author tmjee
 */
public class Arguments {

    private final int iterations;
    private final int minStrides;
    private final int maxStrides;
    private final long time;
    private final int userCpu;
    private final List<String> testClasses;
    private final boolean isRunAllTests;

    private Arguments(
            int iterations,
            int minStrides,
            int maxStrides,
            long time,
            int userCpu,
            List<String> testClasses
            ){
        this.iterations = iterations;
        this.minStrides = minStrides;
        this.maxStrides = maxStrides;
        this.time = time;
        this.userCpu = userCpu;
        this.testClasses = Collections.unmodifiableList(testClasses);
        this.isRunAllTests = testClasses.isEmpty();
    }


    public int iterations() { return iterations; }
    public int minStrides() { return minStrides; }
    public int maxStrides() { return maxStrides; }
    public long time() { return time; }
    public int userCpu() { return userCpu; }
    public List<String> testClasses() { return testClasses; }
    public boolean isRunAllTests() { return isRunAllTests; }


    public static void main(String[] args) throws Exception {
        Arguments.parse(new String[0]);
    }


    ///// =====  static  =====================================================================================
    public static Arguments parse(String[] args) throws IOException {
        OptionParser optionParser = new OptionParser();

        OptionSpec<Integer> iterationsOptionSpec =
                optionParser.accepts("iterations", "iterations per tests")
                    .withRequiredArg().ofType(Integer.class).describedAs("itr");

        OptionSpec<Integer> minStridesPerIterationOptionSpec =
                optionParser.accepts("minStridesPerIteration", "min strides per iterations")
                    .withRequiredArg().ofType(Integer.class).describedAs("minStrides");

        OptionSpec<Integer> maxStridesPerIterationOptionSpec =
                optionParser.accepts("maxStridesPerIteration", "max strides per iterations")
                    .withRequiredArg().ofType(Integer.class).describedAs("maxStrides");

        OptionSpec<Long> timeOptionSpec =
                optionParser.accepts("time", "time spend on tests")
                    .withRequiredArg().ofType(Long.class).describedAs("time");

        OptionSpec<Integer> userCpuOptionSpec =
                optionParser.accepts("userCpu", "number of max thread to schedule")
                    .withRequiredArg().ofType(Integer.class).describedAs("userCpu");

        OptionSpec<String> testClassesOptionSpec =
                optionParser.accepts("testClasses", "test classes (can be multiple with comma separated)")
                    .withRequiredArg().ofType(String.class).describedAs("testClasses")
                    .withValuesSeparatedBy(',');


        optionParser.accepts("h", "help");
        optionParser.formatHelpWith(new ArgumentsHelpFormatter());

        OptionSet optionSet = optionParser.parse(args);

        if (optionSet.has("h")) {
            optionParser.printHelpOn(System.out);
            return null;
        }


        int iterations = orDefault(optionSet.valueOf(iterationsOptionSpec), 5);
        int minStrides = orDefault(optionSet.valueOf(minStridesPerIterationOptionSpec), 100);
        int maxStrides = orDefault(optionSet.valueOf(maxStridesPerIterationOptionSpec), 10000);
        long time = orDefault(optionSet.valueOf(timeOptionSpec), 5000L);
        int userCpu = orDefault(optionSet.valueOf(userCpuOptionSpec), 10);
        List<String> testClasses = orDefault(optionSet.valuesOf(testClassesOptionSpec), Collections.emptyList());

        return new Arguments(
                iterations,
                minStrides,
                maxStrides,
                time,
                userCpu,
                testClasses
        );
    }

    private static int orDefault(Integer i, int def) {
        return i == null ? def : i;
    }

    private static long orDefault(Long l, long def) {
        return l == null ? def : l;
    }

    private static <T> List<T> orDefault(List<T> l, List<T> def) {
        return (l == null ? def : l);
    }

    private static String orDefault(String s, String def) {
        return ((s == null || s.isEmpty()) ? def : s);
    }
}
