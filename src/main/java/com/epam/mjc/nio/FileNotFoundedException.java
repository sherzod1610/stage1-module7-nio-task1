package com.epam.mjc.nio;

public class FileNotFoundedException extends RuntimeException {
    public FileNotFoundedException(String message){
        super(message);
    }
}
