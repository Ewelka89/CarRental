package pl.ek.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Data
public class ClientContact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Email
    private String mail;
    @NotEmpty
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_Id")
    private Client client;
}
