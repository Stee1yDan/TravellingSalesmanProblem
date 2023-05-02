package com.example.coursework.util;

import com.example.coursework.model.Node;

public class Utils
{
    public double calculateDistanceBetweenNodes(Node node1, Node node2)
    {
        return Math.sqrt(
                Math.pow((node1.getX() - node2.getX()),2) +
                        Math.pow((node1.getY() - node2.getY()),2));
    }
}
