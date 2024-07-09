package com.corpchat.CorpChat.dbmodels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}