package com.example.coursework.controller;

import com.example.coursework.model.Node;
import com.example.coursework.model.State;
import com.example.coursework.service.BruteForceService;
import com.example.coursework.service.NodeService;
import com.example.coursework.service.SimulatedAnnealingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller
{
    private final NodeService nodeService;
    private final SimulatedAnnealingService simulatedAnnealingService;
    private final BruteForceService bruteForceService;

    @PostMapping
    public ResponseEntity<Void> insertNodes(@RequestBody List<Node> nodeList)
    {
        nodeService.insertNodes(nodeList);
        System.out.println(nodeList.size());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Node>> getNodeList()
    {
        return new ResponseEntity<>(nodeService.getNodeList(), HttpStatus.OK);
    }

    @GetMapping("/simulatedAnnealing")
    public ResponseEntity<State> getSimulatedAnnealingResult()
    {
        return new ResponseEntity<>(simulatedAnnealingService.startSimulatedAnnealing(), HttpStatus.OK);
    }

    @GetMapping("/bruteForce")
    public ResponseEntity<State> getBruteForceResult()
    {
        return new ResponseEntity<>(bruteForceService.startBruteForce(), HttpStatus.OK);
    }
}
