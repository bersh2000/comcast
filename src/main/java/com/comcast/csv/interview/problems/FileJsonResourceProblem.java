package com.comcast.csv.interview.problems;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import com.comcast.csv.meme.Meme;
import com.comcast.csv.meme.YoureDoingItWrongException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Read a list of {@link Meme}s from a JSON source file that might be on the classpath or file system.
 */
public class FileJsonResourceProblem {

    /**
     * Read a list of memes from a JSON file stored on the filesystem
     * 
     * @param file the file to read
     * @return the list of memes read
     */
    public List<Meme> readFromFile(File file) throws YoureDoingItWrongException {

        Reader json = null;
        try {
            json = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new YoureDoingItWrongException("Cannot read from file "+ file, e);
        }
        Gson gson = new Gson();
//        Meme obj2 = gson.fromJson(json, Meme.class);


        Type collectionType = new TypeToken<List<Meme>>(){}.getType();
        List<Meme> result = gson.fromJson(json, collectionType);
        return result;
    }

    /**
     * Read a list of memes from a JSON file stored on the classpath
     * 
     * @param path the path to the resource
     * @return the list of memes read
     */
    public List<Meme> readFromClasspath(String path) throws YoureDoingItWrongException {
        InputStreamReader json = new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path));

        Gson gson = new Gson();
        Type collectionType = new TypeToken<List<Meme>>(){}.getType();
        List<Meme> result = gson.fromJson(json, collectionType);
        return result;
    }

}
