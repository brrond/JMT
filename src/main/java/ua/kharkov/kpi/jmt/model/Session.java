package ua.kharkov.kpi.jmt.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.postgresql.util.PGInterval;
import org.postgresql.util.PGTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity(name="session")
public class Session {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="session_id")
    Long sessionId;

    @Column(name="user_id")
    Long userId;

    @Column(name="date")
    Date date;

    @Column(name="time")
    Time time;


    @Column(name="speed")
    Double speed;

    public Session(long userId, Date date, Time time, double speed) {
        this.userId = userId;
        this.date = date;
        this.time = time;
        this.speed = speed;
    }

}
