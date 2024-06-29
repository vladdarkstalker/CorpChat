package com.corpchat.CorpChat.dbmodels;
import jakarta.persistence.*;
import java.sql.Timestamp;
//import java.util.Objects;

/**
 * Implements the ChannelMember model.
 * The 'channel_members' table stores information about channel participants and their roles.
 * Structure:
 *      id: The unique identifier of the channel participation record (Primary Key).
 *      user_id: The ID of the user who is a member of the channel (Foreign Key, refers to 'users.id').
 *      channel_id: Channel ID (Foreign Key, refers to 'channels.id').
 *      role: The role of the user in the channel ('admin' or 'member').
 *      joined_at: Date and time of joining the channel.
 */

@Entity
@Table(name = "channel_members")
public class ChannelMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "joined_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp joinedAt;

    public ChannelMember() {}

    public ChannelMember(User user, Channel channel, String role, Timestamp joinedAt) {
        this.user = user;
        this.channel = channel;
        this.role = role;
        this.joinedAt = joinedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(Timestamp joinedAt) {
        this.joinedAt = joinedAt;
    }

    @Override
    public String toString() {
        return "ChannelMember{" +
                "id=" + id +
                ", user=" + user +
                ", channel=" + channel +
                ", role='" + role + '\'' +
                ", joinedAt=" + joinedAt +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ChannelMember that = (ChannelMember) o;
//        return id == that.id && Objects.equals(user, that.user) && Objects.equals(channel, that.channel) && Objects.equals(role, that.role) && Objects.equals(joinedAt, that.joinedAt);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, user, channel, role, joinedAt);
//    }
}