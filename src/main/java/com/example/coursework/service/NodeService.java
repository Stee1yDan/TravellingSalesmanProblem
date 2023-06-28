package com.example.coursework.service;

import com.example.coursework.model.Node;
import com.example.coursework.repository.NodeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class NodeService
{
    private final NodeRepository nodeRepository;

    public NodeService(NodeRepository nodeRepository)
    {
        this.nodeRepository = nodeRepository;
    }

    public List<Node> getNodeList()
    {
        return nodeRepository.findAll();
    }

    public void insertNodes(List<Node> nodeList)
    {
        nodeRepository.reassignRepository(nodeList);
    }
}
