package com.maddy.serialization;

import java.io.*;

/**
 * Created by madhukar.b on 23/08/16.
 */

class Student implements Serializable
{
    int id;
    String name;

    public Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

public class SerializationExample
{
    public static void main(String args[]) throws Exception
    {
//        serialize();
        deserialize();
    }

    private static void deserialize() throws IOException, ClassNotFoundException
    {
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));
        Student s=(Student)in.readObject();
        System.out.println(s.id+" "+s.name);

        in.close();
    }

    private static void serialize() throws IOException
    {
        Student s1 = new Student(211, "ravi");

        FileOutputStream fout = new FileOutputStream("f.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);

        out.writeObject(s1);
        out.flush();
        out.close();
        System.out.println("success");
    }
}
