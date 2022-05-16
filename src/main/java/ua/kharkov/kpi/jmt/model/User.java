package ua.kharkov.kpi.jmt.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity(name="account")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column(name="email")
    private String email;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="date_of_registration")
    private Date dateOfRegistration;

    @Column(name="photo")
    private String photoPath = null;

    public User(String email, String username, String password, Date dateOfRegistration, String photoPath) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfRegistration = dateOfRegistration;
        this.photoPath = photoPath;
    }
}
