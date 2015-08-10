package com.tmjee.linearisation.processor;

import java.util.*;

/**
 * @author tmjee
 */
public class Test {

    private final String name;
    private final String description;
    private final String runner;
    private final String invariant;
    private final String record;
    private final Set<Consequence> consequences;
    private final List<String> references;
    private final List<String> players;
    private final String test;

    private Test(String name, String description, String runner, String invariant, String record,
                 Set<Consequence> conseqeunces, List<String> references, String test, List<String> players) {
        this.name = name;
        this.description = description;
        this.runner = runner;
        this.invariant = invariant;
        this.record = record;
        this.consequences = Collections.unmodifiableSet(conseqeunces);
        this.references = Collections.unmodifiableList(references);
        this.test = test;
        this.players = Collections.unmodifiableList(players);
    }


    public String name() { return name; }
    public String description() { return description; }
    public String runner() { return runner; }
    public String invariant() { return invariant; }


    public static class Consequence {
        private final String id;
        private final Expectation expectation;
        private final String description;

        private Consequence(String id, Expectation expectation, String description) {
            this.id = id;
            this.expectation = expectation;
            this.description = description;
        }
    }


    /**
     * @author tmjee
     */
    public static class TestBuilder {
        private String name;
        private String description;
        private String runner;
        private String invariant;
        private String record;
        private String test;
        private List<String> players = new ArrayList<String>();
        private Set<Consequence> consequences = new LinkedHashSet<>();
        private List<String> references = new ArrayList<>();

        public TestBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public TestBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public TestBuilder withRunner(String runner) {
            this.runner = runner;
            return this;
        }

        public TestBuilder withInvariant(String invariant) {
            this.invariant = invariant;
            return this;
        }

        public TestBuilder withTest(String test) {
            this.test = test;
            return this;
        }

        public TestBuilder addPlayer(String player) {
           this.players.add(player);
            return this;
        }

        public TestBuilder addConsequence(String id, Expectation expectation, String description) {
            this.consequences.add(new Consequence(id, expectation, description));
            return this;
        }

        public TestBuilder withRecord(String record) {
            this.record = record;
            return this;
        }

        public TestBuilder addReference(String reference) {
            this.references.add(reference);
            return this;
        }

        public Test build() {
            return new Test(name, description, runner, invariant, record, consequences, references, test, players);
        }
    }
}
