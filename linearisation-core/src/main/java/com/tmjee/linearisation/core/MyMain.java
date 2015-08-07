package com.tmjee.linearisation.core;

import com.tmjee.linearisation.processor.Invariant;
import com.tmjee.linearisation.processor.Linearisable;

public class MyMain {

    public static void main(String[] args) throws Exception {

        new Internal1();

    }


    @Linearisable
    static class Internal1 {

    }


    @Invariant
    static class Internal2 {

    }


}
