package sn.esmt.scolarite.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//?
@Entity
@Table(name="appusers")
public class AppUserEntity {
    @Id//JPA ID est clée primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto-increment
    private int id;
    @Column(length = 150,nullable = false)
    private String firstName;
    @Column(length = 100,nullable = false)
    private String lastName;
    @Column(length = 200,nullable = false,unique = true)
    private String email;
    @Column(length = 200,nullable = false)
    private String password;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private Genre genre;

}
