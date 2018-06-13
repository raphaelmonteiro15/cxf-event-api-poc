package com.file;

import com.listener.FileListener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FileUtil {

    private Set<FileListener> listeners = new HashSet<>();

    public FileUtil() {
    }

    public void watchFiles(Path dirsPath) throws IOException, InterruptedException {
        var watchService = FileSystems.getDefault().newWatchService();
        dirsPath.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE
        );

        WatchKey watchKey;
        while ((watchKey = watchService.take()) != null) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                if (isNotTemporaryFile(event)) {
                    notifyListeners(read(Collections.singletonList(new File(dirsPath + "/" + event.context().toString()))));
                }
            }
            watchKey.reset();
        }

    }

    private boolean isNotTemporaryFile(WatchEvent<?> event) {
        return !event.context().toString().contains("___jb_tmp___")
                && !event.context().toString().contains("___jb_old___");
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


    public void notifyListeners(List<String> lines) {
        listeners.parallelStream()
                .forEach(ls -> ls.proccess(lines));
    }

    public void write(Path path, String text) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void registerListeners(Set<? extends FileListener> listeners) {
        this.listeners.addAll(listeners);
    }
}
