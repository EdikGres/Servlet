package com.example.testservlet;

import jakarta.servlet.ServletContext;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jokes {
    private String filename; //  "/resources/jokes.txt"
    private List<String> jokes;
    private InputStream inputStream;
    private Random rand;
    private Stream<String> strings;
    ServletContext sc;

    Jokes(String filename, ServletContext sc){
        this.filename = filename;
        this.sc = sc;
        rand = new Random(new Date().getTime());
        inputStream = sc.getResourceAsStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        strings = reader.lines();
        jokes = strings.collect(Collectors.toList());
        System.out.println(jokes.toString());
    }

    String getRandomJoke(){
        return new String(jokes.get(rand.nextInt(jokes.size())));
    }


}
