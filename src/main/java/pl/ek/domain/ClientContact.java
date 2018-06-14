package pl.ek.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
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

    public ClientContact(){}

    private ClientContact(ClientContactBuilder clientContactBuilder){
        this.id=clientContactBuilder.id;
        this.mail=clientContactBuilder.mail;
        this.phoneNumber=clientContactBuilder.phoneNumber;
        this.client=clientContactBuilder.client;
    }

    public Long getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public static class ClientContactBuilder {
        private Long id;
        private String mail;
        private String phoneNumber;
        private Client client;

        public ClientContactBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ClientContactBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public ClientContactBuilder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public ClientContactBuilder client(Client client) {
            this.client = client;
            return this;
        }

        public ClientContact build() {
            return new ClientContact(this);
        }
    }
}
