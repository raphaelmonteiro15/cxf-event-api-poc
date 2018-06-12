package com.listeners;

import java.util.List;

@FunctionalInterface
public interface FileListener {
    void proccess(List<String> lines);
}
