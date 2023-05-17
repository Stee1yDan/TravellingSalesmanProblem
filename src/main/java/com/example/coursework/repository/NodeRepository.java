package com.example.coursework.repository;

import com.example.coursework.model.Node;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@Scope("singleton")
public class NodeRepository
{
    private List<Node> repository = new ArrayList<>();

    public List<Node> findAll()
    {
        return repository;
    }

    public double calculateDistance(int id1, int id2)
    {
        return calculateDistanceHelper(repository.get(id1), repository.get(id2));
    }

    private double calculateDistanceHelper(Node node1, Node node2)
    {
        return Math.sqrt(
                Math.pow((node1.getX() - node2.getX()), 2) +
                        Math.pow((node1.getY() - node2.getY()), 2));
    }

    public double calculatePathDistance()
    {
        int path = 0;
        int size = repository.size() - 1;

        for (int i = 0; i < size; i++)
        {
            path += calculateDistance(i, i + 1);
        }
        return path + calculateDistance(0, repository.size() - 1);
    }

    public void shuffle()
    {
        Collections.shuffle(repository);
    }
    public void reassignRepository(List<Node> nodeList)
    {
        repository = nodeList;
    }
}

