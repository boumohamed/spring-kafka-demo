package me.bouzri.springcloudekafkademo.web;

import lombok.AllArgsConstructor;
import me.bouzri.springcloudekafkademo.entities.PageEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
@AllArgsConstructor
public class PageEventController {

    private StreamBridge bridge;

    @GetMapping("/publish/{topic}/{name}")
    public PageEvent publish(@PathVariable String name, @PathVariable String topic)
    {
        PageEvent p = new PageEvent(name, Math.random() > 0.5 ? "Bouzri" : "Asri", new Date(), new Random().nextInt(5000));
        bridge.send(topic, p);
        return p;

    }
}
