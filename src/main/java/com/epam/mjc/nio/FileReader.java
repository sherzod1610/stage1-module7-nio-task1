package com.epam.mjc.nio;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new java.io.FileReader(file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            assert reader != null;
            reader.close();
        }
        String line;
                String name = null;
                int age = 0;
                String email = null;
                Long phone = null;

                while (true) {
                    try {
                        if ((line = reader.readLine()) == null) break;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    String[] tokens = line.split(":");
                    String key = tokens[0].trim();
                    String value = tokens[1].trim();

                    switch (key) {
                        case "Name":
                            name = value;
                            break;
                        case "Age":
                            age = Integer.parseInt(value);
                            break;
                        case "Email":
                            email = value;
                            break;
                        case "Phone":
                            phone = Long.valueOf(value);
                            break;
                        default:
                            throw new FileNotFoundedException("Not");
                    }
                }

                return new Profile(name, age, email, phone);
            }
        }
