package com.example.coursework.controller;

import com.example.coursework.model.Node;
import com.example.coursework.model.State;
import com.example.coursework.service.NodeService;
import com.example.coursework.service.SimulatedAnnealingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class Controller
{
    private final NodeService nodeService;
    private final SimulatedAnnealingService simulatedAnnealingService;

    public Controller(NodeService nodeService, SimulatedAnnealingService simulatedAnnealingService)
    {
        this.nodeService = nodeService;
        this.simulatedAnnealingService = simulatedAnnealingService;
    }

    @PostMapping
    public ResponseEntity<Void> insertNodes(@RequestBody List<Node> nodeList)
    {
        nodeService.insertNodes(nodeList);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Node>> getNodeList()
    {
        return new ResponseEntity<>(nodeService.getNodeList(), HttpStatus.OK);
    }

    @GetMapping("/result")
    public ResponseEntity<State> getResult()
    {
        return new ResponseEntity<>(simulatedAnnealingService.startSimulatedAnnealing(), HttpStatus.OK);
    }
}
