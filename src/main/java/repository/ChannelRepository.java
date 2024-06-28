package repository;

import dbmodels.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {
    List<Channel> findByName(String name);
    List<Channel> findByCreatedById(Integer createdById);
}
