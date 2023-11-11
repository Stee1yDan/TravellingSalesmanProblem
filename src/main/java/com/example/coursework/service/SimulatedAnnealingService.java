package com.example.coursework.service;

import com.example.coursework.model.State;
import com.example.coursework.repository.NodeRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class SimulatedAnnealingService
{
    private double temperature = 600;
    private double minTemperature = 10;
    private final double temperatureConst = 0.05;
    private final NodeRepository nodeRepository;

    public SimulatedAnnealingService(NodeRepository nodeRepository)
    {
        this.nodeRepository = nodeRepository;
    }

    public State startSimulatedAnnealing()
    {
        State state = new State(nodeRepository.calculatePathDistance());

        while (temperature > minTemperature)
        {
            nodeRepository.shuffle();
            State nextState = new State(nodeRepository.calculatePathDistance());

            System.out.println("Current energy " + state.getEnergy());
            System.out.println("next state energy " + nextState.getEnergy());

            double deltaEnergy = state.getEnergy() - nextState.getEnergy();

            System.out.println("Delta energy " + deltaEnergy);

            if (deltaEnergy > 0)
            {
                state = nextState;
            }
            else if (getProbability(deltaEnergy) < Math.random())
            {
                state = nextState;
                System.out.println("Changed to higher energy state with probability of " + getProbability(deltaEnergy) + " where temp was " + temperature);
            }

            System.out.println("New Current energy " + state.getEnergy());
            System.out.println();

            decreaseTemperature();
        }

        temperature = 600;

        return state;
    }

    private void decreaseTemperature()
    {
        temperature -= temperatureConst;
    }

    private double getProbability(double deltaEnergy)
    {
        return Math.exp(-deltaEnergy / temperature);
    }
}
