package pl.ek.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ClientAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;
    private String house;
    private String flat;
    private String postcode;
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_Id")
    private Client client;
}
