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
        if (array.length!=0){
            profile.setName(array[1]);
            profile.setAge(Integer.valueOf(array[3]));
            profile.setEmail(array[5]);
            profile.setPhone(Long.valueOf(array[7]));
            return profile;
        }
        throw new IndexOutOfBoundsException();
    }

    public String readFile(File file) throws IOException {
        StringBuilder stringFile = new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream(file);

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while ((bufferedReader.readLine()) != null) {
                stringFile.append(bufferedReader.readLine()).append(" ");
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }
        return stringFile.toString();
    }


    public String[] getInformation(String text) {
        return text.split("\n");
    }
}