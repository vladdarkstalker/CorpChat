package com.corpchat.CorpChat.service;

import com.corpchat.CorpChat.dbmodels.ChannelMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corpchat.CorpChat.repository.ChannelMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelMemberService {

    @Autowired
    private ChannelMemberRepository channelMemberRepository;

    public List<ChannelMember> getAllChannelMembers() {
        return channelMemberRepository.findAll();
    }

    public Optional<ChannelMember> getChannelMemberById(Integer id) {
        return channelMemberRepository.findById(id);
    }

    public List<ChannelMember> getChannelMembersByUserId(Integer userId) {
        return channelMemberRepository.findByUserId(userId);
    }

    public List<ChannelMember> getChannelMembersByChannelId(Integer channelId) {
        return channelMemberRepository.findByChannelId(channelId);
    }

    public ChannelMember createChannelMember(ChannelMember channelMember) {
        return channelMemberRepository.save(channelMember);
    }

    public ChannelMember updateChannelMember(ChannelMember channelMember) {
        return channelMemberRepository.save(channelMember);
    }

    public void deleteChannelMember(Integer id) {
        channelMemberRepository.deleteById(id);
    }
}
