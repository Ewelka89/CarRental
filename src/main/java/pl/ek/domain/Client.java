package pl.ek.domain;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    private String birthdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactId")
    private ClientContact clientContact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private ClientAddress clientAddress;

    @Enumerated(EnumType.STRING)
    private ClientType clientType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Rental> rentals= new ArrayList<>();

    public Client(){}

    private Client(ClientBuilder clientBuilder){
        this.id=clientBuilder.id;
        this.name=clientBuilder.name;
        this.surname=clientBuilder.surname;
        this.birthdate =clientBuilder.birthdate;
        this.clientContact=clientBuilder.clientContact;
        this.clientAddress=clientBuilder.clientAddress;
        this.clientType=clientBuilder.clientType;
        this.rentals=clientBuilder.rentals;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public ClientContact getClientContact() {
        return clientContact;
    }

    public ClientAddress getClientAddress() {
        return clientAddress;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setClientContact(ClientContact clientContact) {
        this.clientContact = clientContact;
    }

    public void setClientAddress(ClientAddress clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public static class ClientBuilder{
        private Long id;
        private String name;
        private String surname;
        private String birthdate;
        private ClientContact clientContact;
        private ClientAddress clientAddress;
        private ClientType clientType;
        private List<Rental> rentals;

        public ClientBuilder id(Long id){
            this.id=id;
            return this;
        }
        public ClientBuilder name(String name){
            this.name=name;
            return this;
        }
        public ClientBuilder surname(String surname){
            this.surname=surname;
            return this;
        }
        public ClientBuilder birthdate(String birthdate){
            this.birthdate=birthdate;
            return this;
        }
        public ClientBuilder clientContact(ClientContact clientContact){
            this.clientContact=clientContact;
            return this;
        }
        public ClientBuilder clientAddress(ClientAddress clientAddress){
            this.clientAddress=clientAddress;
            return this;
        }
        public ClientBuilder clientType(ClientType clientType){
            this.clientType=clientType;
            return this;
        }
        public ClientBuilder rentals(List<Rental> rentals){
            this.rentals=rentals;
            return this;
        }
        public Client build(){
            return new Client(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(name, client.name) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(birthdate, client.birthdate) &&
                Objects.equals(clientContact, client.clientContact) &&
                Objects.equals(clientAddress, client.clientAddress) &&
                clientType == client.clientType &&
                Objects.equals(rentals, client.rentals);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, birthdate, clientContact, clientAddress, clientType, rentals);
    }
}
