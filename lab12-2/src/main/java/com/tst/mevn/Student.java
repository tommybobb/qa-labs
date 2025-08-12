package com.tst.mevn;

import java.util.ArrayList;

class Student{
   String name; 
   int age;
   ArrayList<String> subjects = new ArrayList<>();

   public Student(String name, int age) {
     this.name = name; this.age = age;
     subjects.add("Java");
     subjects.add("C#");
     subjects.add("Network");
   }
}

