package com.tmjee.linearisation.processor;

/**
 * @author tmjee
 */
public class Test {

    private final String name;
    private final String description;
    private final String runner;
    private final int playerCount;

    public Test(String name, String description, String runner, int playerCount) {
        this.name = name;
        this.description = description;
        this.runner = runner;
        this.playerCount = playerCount;
    }


    public String name() { return name; }
    public String description() { return description; }
    public String runner() { return runner; }
    public int playerCount() { return playerCount; }

}
