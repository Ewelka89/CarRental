package pl.ek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.ek.domain.Rental;
import pl.ek.services.CarService;
import pl.ek.services.ClientService;
import pl.ek.services.RentalService;

import javax.validation.Valid;

@Controller
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    private RentalService rentalService;
    @Autowired
    private CarService carService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/showAll")
    public String findAll(Model model) {
        model.addAttribute("rents", rentalService.findAll());
        return "rentalHome";
    }

    @RequestMapping("/start")
    public String start() {
        return "start";
    }

    @GetMapping("/add")
    public String showForm(Model model, @RequestParam(name = "id", required = false) Long carId) {
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("clients", clientService.findAll());

        Rental rental = new Rental();
        if (carId != null) {
            rental.setCar(carService.findOne(carId));
        }
        model.addAttribute("rental", rental);

        return "rentalForm";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute @Valid Rental rental, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "rentalForm";
        } else {
            rentalService.save(rental);
            model.addAttribute("rents", rentalService.findAll());
            return "rentalHome";
        }
    }

}
