package com.epam.mjc.nio;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try {
            return returnProfile(file);
        } catch (IOException e) {
            throw new FileNotFoundedException(e);
        }
    }

    public Profile returnProfile(File file) throws IOException {
        FileReader fileReader = new FileReader();
        Profile profile = new Profile();
        String[] array;
        array = fileReader.getInformation(fileReader.readFile(file));
        if (array.length != 0) {
            profile.setName(array[1]);
            profile.setAge(Integer.valueOf(array[3]));
            profile.setEmail(array[5]);
            profile.setPhone(Long.valueOf(array[7]));
            return profile;
        }
        throw new IndexOutOfBoundsException();
    }

    public String readFile(File file){
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(file));
            StringBuilder stringFile = null;
            while ((stringFile = new StringBuilder(bufferedReader.readLine())) != null) {
                return stringFile.toString();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public String[] getInformation(String text) {

        return text.split("\n");
    }
}