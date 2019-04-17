package com.matchmaking.player.controller;

import com.matchmaking.player.model.Queue;
import com.matchmaking.player.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matchmaking/players/v2/queues")
public class QueueController {

    private QueueService queueService;

    @Autowired
    public QueueController(QueueService queueService) {
        this.queueService = queueService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Queue> getAllQueues() {
        return queueService.getAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Queue getQueueById(@PathVariable("id") String id) {
        return queueService.get(id);
    }
}
