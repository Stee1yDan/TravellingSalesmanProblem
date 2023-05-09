package com.example.coursework.model;

import com.example.coursework.repository.NodeRepository;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
public class State
{
    private double energy;
    public State(double energy)
    {
        this.energy = energy;
    }
}
