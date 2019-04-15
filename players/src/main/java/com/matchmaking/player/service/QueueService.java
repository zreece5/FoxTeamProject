package com.matchmaking.player.service;

import com.matchmaking.player.model.Queue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QueueService {

    private final int TTL = 60 * 60 * 1000; // 60*60*1000 = 60 minutes

    private Set<Queue> queueList = new LinkedHashSet<>();

    public List<Queue> getAll() {
        purgeOldQueues();
        return new ArrayList<>(queueList);
    }

    public Queue get(String id) {
        purgeOldQueues();
        return queueList.stream().filter(q->q.getId().equals(id)).findFirst().orElse(null);
    }

    public void put(Queue queue) {
        purgeOldQueues();
        queueList.add(queue);
    }

    private void purgeOldQueues() {
        List<Queue> remove = queueList.stream().filter(q -> (q.getUpdated() + TTL) < System.currentTimeMillis()).collect(Collectors.toList());
        queueList.removeAll(remove);
    }
}
