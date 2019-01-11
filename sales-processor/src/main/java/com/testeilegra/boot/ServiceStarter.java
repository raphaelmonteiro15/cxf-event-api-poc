package com.testeilegra.boot;

import com.testeilegra.processor.FilesInfoProcessor;

public class ServiceStarter {

    private static FilesInfoProcessor processor = new FilesInfoProcessor();

    public static void main(String... args) {
        processor.processFilesInformations();
    }
}
