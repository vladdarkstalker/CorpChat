package com.corpchat.CorpChat.service;

import com.corpchat.CorpChat.dbmodels.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corpchat.CorpChat.repository.ChannelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    public Optional<Channel> getChannelById(Integer id) {
        return channelRepository.findById(id);
    }

    public List<Channel> getChannelsByName(String name) {
        return channelRepository.findByName(name);
    }

    public List<Channel> getChannelsByCreatedById(Integer createdById) {
        return channelRepository.findByCreatedById(createdById);
    }

    public Channel createChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    public Channel updateChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    public void deleteChannel(Integer id) {
        channelRepository.deleteById(id);
    }
}
