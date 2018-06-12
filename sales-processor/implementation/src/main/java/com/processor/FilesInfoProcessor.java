package com.processor;

import com.dataanalytic.DataAnalytic;
import com.file.FileUtil;
import com.listeners.CustomerFileListener;
import com.listeners.FileListener;
import com.listeners.SaleFileListener;
import com.listeners.SalesmanFileListener;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FilesInfoProcessor {

    private static Path dirsPath = Paths.get("./files");
    private FileUtil fileUtil = new FileUtil();
    private DataAnalytic dataAnalytic = new DataAnalytic();
    private Set<FileListener> listeners =
            new HashSet(Arrays.asList(new CustomerFileListener(),
            new SalesmanFileListener(),
            new SaleFileListener()));

    public void processFilesInformations(){
        registerFileListeners();
        readExistentFiles();
        try {
            fileUtil.watchFiles();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerFileListeners(){
        fileUtil.registerListeners(listeners);
    }

    private void readExistentFiles() {
        var lines = fileUtil.read(Arrays.asList(new File(dirsPath.getFileName().toString()).listFiles()));
        if(!lines.isEmpty()) {
            fileUtil.notifyListeners(lines);
            dataAnalytic.formModel();
        }
    }
}
