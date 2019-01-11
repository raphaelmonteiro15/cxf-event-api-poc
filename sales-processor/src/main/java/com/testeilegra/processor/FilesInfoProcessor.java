package com.testeilegra.processor;

import com.testeilegra.dataanalytic.DataAnalytic;
import com.testeilegra.features.customer.CustomerFileListener;
import com.testeilegra.features.sales.SaleFileListener;
import com.testeilegra.features.salesman.SalesmanFileListener;
import com.testeilegra.file.FileUtil;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class FilesInfoProcessor {

    private static final Path dirsPath = Paths.get("./files");
    private FileUtil fileUtil;
    private DataAnalytic dataAnalytic;
    private HashSet listeners;

    public FilesInfoProcessor() {
        this.fileUtil = new FileUtil();
        this.dataAnalytic = new DataAnalytic();
        this.listeners = new HashSet(Arrays.asList(new CustomerFileListener(),
                new SalesmanFileListener(),
                new SaleFileListener()));
    }

    public void processFilesInformations() {
        registerFileListeners();
        readExistentFiles();
        try {
            fileUtil.watchFiles(dirsPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerFileListeners() {
        fileUtil.registerListeners(listeners);
    }

    private void readExistentFiles() {
        List<String> lines = fileUtil.read(Arrays.asList(
                Objects.requireNonNull(new File(dirsPath.getFileName().toString())
                        .listFiles((dir, name) -> name.endsWith(".dat")))));
        if (!lines.isEmpty()) {
            fileUtil.publishLines(lines);
            dataAnalytic.analyseResult();
        }
    }
}
