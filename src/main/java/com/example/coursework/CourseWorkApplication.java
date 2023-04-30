package com.example.coursework;

import com.example.coursework.model.Node;
import com.example.coursework.model.State;
import com.example.coursework.repository.NodeRepository;
import com.example.coursework.service.DecisionMaker;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController()
@RequestMapping("/api")
@SpringBootApplication
public class CourseWorkApplication
{

    private final NodeRepository nodeRepository = new NodeRepository();
    private final DecisionMaker decisionMaker = new DecisionMaker(nodeRepository);
    Random random = new Random();

    public static void main(String[] args)
    {
        SpringApplication.run(CourseWorkApplication.class, args);
    }


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
        return decisionMaker.startSimulatedAnnealing();
    }
//
//    @Bean
//    CommandLineRunner runner()
//    {
//        return args ->
//        {

//            for (int i = 0; i < 100; i++)
//            {
//                Node node = new Node(random.nextInt(1000), random.nextInt(1000));
//                nodeRepository.save(node);
//            }
//
//            decisionMaker.startSimulatedAnnealing();
//        };
//    }


}
