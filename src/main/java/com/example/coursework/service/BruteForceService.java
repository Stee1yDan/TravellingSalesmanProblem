package com.example.coursework.service;

import com.example.coursework.model.Node;
import com.example.coursework.model.State;
import com.example.coursework.repository.NodeRepository;
import org.springframework.stereotype.Service;

@Service
public class BruteForceService
{
    private final NodeRepository nodeRepository;
    int size;
    State state;

    public BruteForceService(NodeRepository nodeRepository)
    {
        this.nodeRepository = nodeRepository;
    }

    public State startBruteForce()
    {
        this.size = nodeRepository.getSize();
        this.state = new State(nodeRepository.calculatePathDistance());

        return bruteForceHelper(size);
    }


    private State bruteForceHelper(int newSize)
    {
        if (newSize == 1) { return null; }

        for (int i = 0; i < newSize; i++)
        {
            bruteForceHelper(newSize - 1);

            if (newSize == 2)
            {
                State nextState = new State(nodeRepository.calculatePathDistance());

                if (nextState.getEnergy() < state.getEnergy())
                {
                    state = nextState;
                }
            }

            rotate(newSize);
        }

        return state;
    }

    private void rotate(int newSize)
    {
        int i;
        int position = size - newSize;
        Node temp = nodeRepository.getElement(position);

        for (i = position + 1; i < size; i++)
        {
            nodeRepository.setElement(i-1,nodeRepository.getElement(i));
        }

        nodeRepository.setElement(i-1,temp);
    }
}
