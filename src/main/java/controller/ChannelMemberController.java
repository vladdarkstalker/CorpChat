package controller;

import dbmodels.ChannelMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ChannelMemberService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/channel-members")
public class ChannelMemberController {

    @Autowired
    private ChannelMemberService channelMemberService;

    @GetMapping
    public List<ChannelMember> getAllChannelMembers() {
        return channelMemberService.getAllChannelMembers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChannelMember> getChannelMemberById(@PathVariable Integer id) {
        Optional<ChannelMember> channelMember = channelMemberService.getChannelMemberById(id);
        if (channelMember.isPresent()) {
            return ResponseEntity.ok(channelMember.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public List<ChannelMember> getChannelMembersByUserId(@PathVariable Integer userId) {
        return channelMemberService.getChannelMembersByUserId(userId);
    }

    @GetMapping("/channel/{channelId}")
    public List<ChannelMember> getChannelMembersByChannelId(@PathVariable Integer channelId) {
        return channelMemberService.getChannelMembersByChannelId(channelId);
    }

    @PostMapping
    public ResponseEntity<ChannelMember> createChannelMember(@RequestBody ChannelMember channelMember) {
        ChannelMember createdChannelMember = channelMemberService.createChannelMember(channelMember);
        return ResponseEntity.ok(createdChannelMember);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChannelMember> updateChannelMember(@PathVariable Integer id, @RequestBody ChannelMember channelMemberDetails) {
        Optional<ChannelMember> channelMemberOptional = channelMemberService.getChannelMemberById(id);
        if (channelMemberOptional.isPresent()) {
            ChannelMember channelMember = channelMemberOptional.get();
            channelMember.setUser(channelMemberDetails.getUser());
            channelMember.setChannel(channelMemberDetails.getChannel());
            channelMember.setRole(channelMemberDetails.getRole());
            ChannelMember updatedChannelMember = channelMemberService.updateChannelMember(channelMember);
            return ResponseEntity.ok(updatedChannelMember);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChannelMember(@PathVariable Integer id) {
        channelMemberService.deleteChannelMember(id);
        return ResponseEntity.noContent().build();
    }
}