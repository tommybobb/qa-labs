package com.tst.mevn;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        
        Gson gson = new Gson();

        String fileName = "src\\main\\resources\\customers.json";

        String content = new String(Files.readAllBytes(Paths.get(fileName)));

        Customer[] customers = gson.fromJson(content, Customer[].class);

        System.out.println(customers[0].CustomerID);


        for(Customer cus : customers){
            System.out.println(cus.CustomerID);

        }


        int[] nos = {1,3,5,7,9};
        String res = gson.toJson(nos);
        System.out.println(res);

        String[] names= {"Bob","Fred","Wilma"};
        res = gson.toJson(names);
        System.out.println(res);

        Student[] students = {
            new Student("Bob",21), 
            new Student("Fred",32), 
            new Student("Wilma",26)
        };

        Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();


        res = gsonBuilder.toJson(students);

        String newPath = "src\\main\\resources\\list2.json";

        // try (BufferedWriter r = new BufferedWriter(new FileWriter(newPath))){
        //     r.write(res);
        // }

        Files.write(Paths.get(newPath), res.getBytes(StandardCharsets.UTF_8));



    }
}