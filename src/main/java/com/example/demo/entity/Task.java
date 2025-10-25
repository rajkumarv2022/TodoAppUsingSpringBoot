package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String description;
    boolean status;

    public Task() {}

    public Task(String title,String description)
    {
        this.title=title;
        this.description=description;
        this.status=false;
    }

    public Task(String title,String description,boolean status)
    {
        this.title=title;
        this.description=description;
        this.status=status;
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    public boolean getStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status=status;
    }

    public void setTitle(String title)
    {
        this.title=title;
    }

    public void setDescription(String description)
    {
        this.description=description;
    }

    public boolean isStatus()
    {
        return status;
    }

}
