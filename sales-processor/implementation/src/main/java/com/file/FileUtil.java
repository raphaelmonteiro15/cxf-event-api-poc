package com.file;

import com.dataanalytic.DataAnalytic;
import com.listeners.FileListener;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FileUtil {

    private Path dirsPath = Paths.get("./files");
    private Set<FileListener> listeners = new HashSet<>();
    private DataAnalytic dataAnalytic = new DataAnalytic();

    public FileUtil() {
    }

    public void watchFiles() throws IOException, InterruptedException {
        var watchService = FileSystems.getDefault().newWatchService();
        dirsPath.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE
        );

        WatchKey watchKey;
        while ((watchKey = watchService.take()) != null) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                if(!event.context().toString().contains("___jb_tmp___") && !event.context().toString().contains("___jb_old___")) {
                    notifyListeners(read(Arrays.asList(new File(dirsPath + "/" + event.context().toString()))));
                    dataAnalytic.formModel();
                }
            }
            watchKey.reset();
        }

    }
    public List<String> read(List<File> files) {
        List<String> lines = files.stream().map(f -> {
            try {
                return Files.readAllLines(f.toPath());
            } catch (IOException e) {
                System.out.println("Error to read file: " + e.getMessage());
                return null;
            }
        }).flatMap(l -> l.stream()).collect(Collectors.toList());
        return lines;
    }


    public void notifyListeners(List<String> lines){
        listeners.parallelStream()
                .forEach(ls -> ls.proccess(lines));
    }

    public void registerListeners(Set<? extends FileListener> listeners){
        this.listeners.addAll(listeners);
    }
}
