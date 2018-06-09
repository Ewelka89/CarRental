package pl.ek;

import org.springframework.stereotype.Component;
import pl.ek.domain.Car;
import pl.ek.domain.Client;
import pl.ek.domain.Rental;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataToTestRepository {

    public List<Car> carList(){
        List<Car> carList= new ArrayList<>();
        Car car= new Car.CarBuilder()
                .brand("ford")
                .model("focus")
                .year("2000")
                .build();
        carList.add(car);
        Car car2= new Car.CarBuilder()
                .brand("opel")
                .model("astra")
                .year("2001")
                .build();
        carList.add(car2);

        return carList;
    }

    public List<Client> clientList(){
        List<Client> clientList= new ArrayList<>();
        Client client= new Client.ClientBuilder()
                .id(1L)
                .name("ewa")
                .surname("kot")
                .birthdate("12.12.1234")
                .build();
        clientList.add(client);
        Client client2= new Client.ClientBuilder()
                .id(2L)
                .name("jan")
                .surname("kot")
                .birthdate("10.12.1934")
                .build();
        clientList.add(client2);
        Client client3= new Client.ClientBuilder()
                .id(3L)
                .name("jan")
                .surname("mak")
                .birthdate("10.01.1934")
                .build();
        clientList.add(client3);

        return clientList;
    }

    public List<Rental> rentalList(){
        List<Rental> rentalList= new ArrayList<>();
        Rental rental= new Rental.RentalBuilder()
                .client(clientList().get(0))
                .car(carList().get(0))
                .dropOffLocation("wawa")
                .build();
        rentalList.add(rental);

        return rentalList;
    }

}
