package pl.ek.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "minimum two characters")
    private String brand;
    @NotEmpty
    @Size(min = 2, message = "minimum two characters")
    private String model;
    @NotEmpty
    @Size(min = 4, max = 4, message = "only 4 digits")
    @Min(0)
    private String year;

    @Enumerated(EnumType.STRING)
    private Body bodyType;

    @Enumerated(EnumType.STRING)
    private Fuel fuelType;

    private boolean airCondition;
    private boolean navi;
    private boolean bluetooth;
    private boolean carAudio;
    private boolean fourWheelDrive;

    @Enumerated(EnumType.STRING)
    private Gearbox gearbox;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "car")
    private List<Rental> rentals = new ArrayList<>();

    public Car() {
    }

    private Car(CarBuilder carBuilder) {
        this.brand = carBuilder.brand;
        this.model = carBuilder.model;
        this.year = carBuilder.year;
        this.bodyType = carBuilder.bodyType;
        this.fuelType = carBuilder.fuelType;
        this.airCondition = carBuilder.airCondition;
        this.navi = carBuilder.navi;
        this.bluetooth = carBuilder.bluetooth;
        this.carAudio = carBuilder.carAudio;
        this.fourWheelDrive = carBuilder.fourWheelDrive;
        this.gearbox = carBuilder.gearbox;
        this.rentals = carBuilder.rentals;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public Body getBodyType() {
        return bodyType;
    }

    public Fuel getFuelType() {
        return fuelType;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public boolean isNavi() {
        return navi;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public boolean isCarAudio() {
        return carAudio;
    }

    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setBodyType(Body bodyType) {
        this.bodyType = bodyType;
    }

    public void setFuelType(Fuel fuelType) {
        this.fuelType = fuelType;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public void setNavi(boolean navi) {
        this.navi = navi;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public void setCarAudio(boolean carAudio) {
        this.carAudio = carAudio;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public static class CarBuilder {

        private String brand;
        private String model;
        private String year;
        private Body bodyType;
        private Fuel fuelType;
        private boolean airCondition;
        private boolean navi;
        private boolean bluetooth;
        private boolean carAudio;
        private boolean fourWheelDrive;
        private Gearbox gearbox;
        private List<Rental> rentals;

        public CarBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder model(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder year(String year) {
            this.year = year;
            return this;
        }

        public CarBuilder bodyType(Body bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        public CarBuilder fuelType(Fuel fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        public CarBuilder airCondition(boolean airCondition) {
            this.airCondition = airCondition;
            return this;
        }

        public CarBuilder navi(boolean navi) {
            this.navi = navi;
            return this;
        }

        public CarBuilder bluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public CarBuilder carAudio(boolean carAudio) {
            this.carAudio = carAudio;
            return this;
        }

        public CarBuilder fourWheelDrive(boolean fourWheelDrive) {
            this.fourWheelDrive = fourWheelDrive;
            return this;
        }

        public CarBuilder gearbox(Gearbox gearbox) {
            this.gearbox = gearbox;
            return this;
        }

        public CarBuilder rentals(List<Rental> rentals) {
            this.rentals = rentals;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return airCondition == car.airCondition &&
                navi == car.navi &&
                bluetooth == car.bluetooth &&
                carAudio == car.carAudio &&
                fourWheelDrive == car.fourWheelDrive &&
                Objects.equals(id, car.id) &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model) &&
                Objects.equals(year, car.year) &&
                bodyType == car.bodyType &&
                fuelType == car.fuelType &&
                gearbox == car.gearbox &&
                Objects.equals(rentals, car.rentals);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, brand, model, year, bodyType, fuelType, airCondition, navi, bluetooth, carAudio, fourWheelDrive, gearbox, rentals);
    }
}
