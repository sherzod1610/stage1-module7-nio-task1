package com.epam.mjc.nio;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        FileReader fileReader = new FileReader();
        Profile profile = new Profile();
        String[] array;
        try {
            array = fileReader.getInformation(fileReader.readFile(file));
        } catch (IOException e) {
            throw new FileNotFoundedException(e);
        }
        if (array.length < 2) {
            throw new IllegalArgumentException("Invalid input file format");
        }
        profile.setName(array[1]);
        profile.setAge(Integer.valueOf(array[3]));
        profile.setEmail(array[5]);
        profile.setPhone(Long.valueOf(array[7]));
        return profile;
    }

    public String readFile(File file) throws IOException {
        StringBuilder stringFile = new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream(file);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringFile.append(line).append(" ");
            }
        }
        return stringFile.toString();
    }


    public String[] getInformation(String text) {
        return text.split("\n");
    }
}
