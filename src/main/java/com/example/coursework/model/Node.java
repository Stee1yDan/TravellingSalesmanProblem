package com.example.coursework.model;

import lombok.Data;

@Data
public class Node
{
    static int id = 0;

    int nodeId;
    int x;
    int y;

    public Node(int x, int y)
    {
        nodeId = id;
        this.x = x;
        this.y = y;
        id++;
    }
}
