package com.epam.mjc.nio;

import java.io.IOException;

public class FileNotFoundedException extends RuntimeException {
    public FileNotFoundedException(IOException message){
        super(message);
    }
}
