package com.tca.entities;

public class Student
{
    private int rno;
    private String name;
    private Double percentage;

    public Student()
    {

    }

    public Student(int rno, String name, Double percentage)
    {
        this.rno = rno;
        this.name = name;
        this.percentage = percentage;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;

    }
    public Double getPercentage() {
        return percentage;
    }
    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString()
    {
        return "{" +
                "rno=" + rno +
                ", name='" + name + '\'' +
                ", percentage=" + percentage +
                '}';
    }

    public  void display()
    {
        System.out.println("RNO: " + rno);
        System.out.println("Name: " + name);
        System.out.println("Percentage: " + percentage);
    }
}
