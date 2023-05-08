package com.example.coursework.model;

import lombok.Data;

@Data
public class Node
{
    int nodeId;
    int x;
    int y;

    public Node(int x, int y, int nodeId)
    {
        this.nodeId = nodeId;
        this.x = x;
        this.y = y;
    }
}
