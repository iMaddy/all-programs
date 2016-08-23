package com.maddy.serialization;

import java.io.*;

/**
 * Created by madhukar.b on 23/08/16.
 */

class Student implements Serializable
{
    int id;
    String name;
    transient int age; // transient doesn't get serialized
    private static String schoolName = "New English School";

    public Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setSchoolName(String sName)
    {
        schoolName = sName;
    }

    public String getSchoolName()
    {
        return schoolName;
    }
}

public class SerializationExample
{
    public static void main(String args[]) throws Exception
    {
        serialize();
        deserialize();
    }

    private static void deserialize() throws IOException, ClassNotFoundException
    {
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));
        Student s=(Student)in.readObject();
        System.out.println(s.id+" "+s.name+" "+ s.age +" " +s.getSchoolName());

        in.close();
    }

    private static void serialize() throws IOException
    {
        Student s = new Student(211, "ravi", 25);
        s.setSchoolName("Sarswati Prashala");

        FileOutputStream fout = new FileOutputStream("f.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);

        System.out.println(s.id+" "+s.name+" "+ s.age +" " +s.getSchoolName());
        out.writeObject(s);
        out.flush();
        out.close();
        System.out.println("Serialized");
    }
}
