package controller;

import dbmodels.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ChannelService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/channels")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping
    public List<Channel> getAllChannels() {
        return channelService.getAllChannels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Channel> getChannelById(@PathVariable Integer id) {
        Optional<Channel> channel = channelService.getChannelById(id);
        if (channel.isPresent()) {
            return ResponseEntity.ok(channel.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name")
    public List<Channel> getChannelsByName(@RequestParam String name) {
        return channelService.getChannelsByName(name);
    }

    @GetMapping("/created-by/{createdById}")
    public List<Channel> getChannelsByCreatedById(@PathVariable Integer createdById) {
        return channelService.getChannelsByCreatedById(createdById);
    }

    @PostMapping
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel) {
        Channel createdChannel = channelService.createChannel(channel);
        return ResponseEntity.ok(createdChannel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Channel> updateChannel(@PathVariable Integer id, @RequestBody Channel channelDetails) {
        Optional<Channel> channelOptional = channelService.getChannelById(id);
        if (channelOptional.isPresent()) {
            Channel channel = channelOptional.get();
            channel.setName(channelDetails.getName());
            channel.setDescription(channelDetails.getDescription());
            channel.setCreatedAt(channelDetails.getCreatedAt());
            channel.setCreatedBy(channelDetails.getCreatedBy());
            Channel updatedChannel = channelService.updateChannel(channel);
            return ResponseEntity.ok(updatedChannel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChannel(@PathVariable Integer id) {
        channelService.deleteChannel(id);
        return ResponseEntity.noContent().build();
    }
}
