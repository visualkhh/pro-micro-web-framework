package com.mwf.test;

import com.mwf.MWF;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException, InterruptedException {
//      log.debug("---");
        new MWF(Test.class).start();
    }
}
