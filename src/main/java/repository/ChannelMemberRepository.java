package repository;

import dbmodels.ChannelMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelMemberRepository extends JpaRepository<ChannelMember, Integer> {
    List<ChannelMember> findByUserId(Integer userId);
    List<ChannelMember> findByChannelId(Integer channelId);
}
