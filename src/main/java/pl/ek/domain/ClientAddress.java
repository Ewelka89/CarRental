package pl.ek.domain;

import javax.persistence.*;

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

    public ClientAddress(){ }

    public ClientAddress(ClientAddressBuilder clientAddressBuilder){
        this.id=clientAddressBuilder.id;
        this.street=clientAddressBuilder.street;
        this.house=clientAddressBuilder.house;
        this.flat=clientAddressBuilder.flat;
        this.postcode=clientAddressBuilder.postcode;
        this.city=clientAddressBuilder.city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public static class ClientAddressBuilder{
        private Long id;
        private String street;
        private String house;
        private String flat;
        private String postcode;
        private String city;
        private Client client;

        public ClientAddressBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public ClientAddressBuilder house(String  house) {
            this.house = house;
            return this;
        }
        public ClientAddressBuilder street(String  street) {
            this.street = street;
            return this;
        }
        public ClientAddressBuilder flat(String  flat) {
            this.flat = flat;
            return this;
        }
        public ClientAddressBuilder postcode(String  postcode) {
            this.postcode = postcode;
            return this;
        }
        public ClientAddressBuilder city(String  city) {
            this.city = city;
            return this;
        }
        public ClientAddressBuilder client(Client  client) {
            this.client = client;
            return this;
        }
        public ClientAddress build(){
            return new ClientAddress(this);
        }
    }
}
