package pl.ek.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @Size(min = 3, message = "minimum three characters")
    private String pickUpLocation;

    @Size(min = 3, message = "minimum three characters")
    private String dropOffLocation;

    @Size(min = 6, message = "minimum four digits")
    private String pickUpDate;

    @Size(min = 6, message = "minimum four digits")
    private String dropOffDate;

    @Enumerated(EnumType.STRING)
    private Payment paymentMethod;

    public Rental() {
    }

    private Rental(RentalBuilder rentalBuilder) {
        this.id = rentalBuilder.id;
        this.car = rentalBuilder.car;
        this.client = rentalBuilder.client;
        this.pickUpLocation = rentalBuilder.pickUpLocation;
        this.dropOffLocation = rentalBuilder.dropOffLocation;
        this.pickUpDate = rentalBuilder.pickUpDate;
        this.dropOffDate = rentalBuilder.dropOffDate;
        this.paymentMethod = rentalBuilder.paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public Client getClient() {
        return client;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public static class RentalBuilder {
        private Long id;
        private Car car;
        private Client client;
        private String pickUpLocation;
        private String dropOffLocation;
        private String pickUpDate;
        private String dropOffDate;
        private Payment paymentMethod;

        public RentalBuilder car(Car car) {
            this.car = car;
            return this;
        }

        public RentalBuilder client(Client client) {
            this.car = car;
            return this;
        }

        public RentalBuilder pickUpLocation(String pickUpLocation) {
            this.pickUpLocation = pickUpLocation;
            return this;
        }

        public RentalBuilder dropOffLocation(String dropOffLocation) {
            this.dropOffLocation = dropOffLocation;
            return this;
        }

        public RentalBuilder pickUpDate(String pickUpDate) {
            this.pickUpDate = pickUpDate;
            return this;
        }

        public RentalBuilder dropOffDate(String dropOffDate) {
            this.dropOffDate = dropOffDate;
            return this;
        }

        public RentalBuilder paymentMethod(Payment paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Rental build() {
            return new Rental(this);
        }
    }

}
