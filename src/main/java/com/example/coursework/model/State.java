package com.example.coursework.model;

import com.example.coursework.repository.NodeRepository;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Data
@Component
@Scope("prototype")
public class State
{
    private final NodeRepository nodeRepository;
    private double energy;

    Random random = new Random();

    public State(NodeRepository nodeRepository)
    {
        this.nodeRepository = nodeRepository;

//        int size = nodeRepository.getSize();
//        nodeRepository.swapNodes(random.nextInt(size), random.nextInt(size));

        nodeRepository.shuffleList();
        energy = nodeRepository.calculatePathDistance();
    }
}
