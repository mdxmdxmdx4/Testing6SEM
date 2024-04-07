package com.belstu.io;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //IO
        //Tasks
        Tasks_main tm = new Tasks_main();
        try {
            tm.processInput(args[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}