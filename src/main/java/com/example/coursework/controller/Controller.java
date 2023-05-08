package com.example.coursework.controller;

import com.example.coursework.model.Node;
import com.example.coursework.model.State;
import com.example.coursework.repository.NodeRepository;
import com.example.coursework.service.NodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class Controller
{
    private final NodeRepository nodeRepository = new NodeRepository();
    private final NodeService nodeService = new NodeService(nodeRepository);
    @PostMapping
    public ResponseEntity<Void> insertNode(@RequestBody List<Node> nodeList)
    {
        nodeRepository.reassignRepository(nodeList);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Node> getNodeList()
    {
        return nodeRepository.findAll();
    }

    @GetMapping("/result")
    public State getResult()
    {
        return nodeService.startSimulatedAnnealing();
    }

    @GetMapping("/path")
    public List<Node> getPath()
    {
        return nodeRepository.findAll();
    }
}
