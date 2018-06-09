package pl.ek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.ek.domain.Car;
import pl.ek.services.CarService;

import javax.validation.Valid;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/showAll")
    public String findAll(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "carHome";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("car", new Car());
        return "carForm";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute @Valid Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "carForm";
        } else {
            carService.save(car);
            model.addAttribute("cars", carService.findAll());
            return "carHome";
        }
    }

    @RequestMapping("/delete")
    public String deleteCar(Model model, @RequestParam(value = "id") Long id) {
        carService.delete(id);
        model.addAttribute("cars", carService.findAll());
        return "carHome";
    }

    @RequestMapping("/showFinder")
    public String findCarByBrand(Model model) {
        model.addAttribute("car", new Car());
        return "carFinder";
    }

    @RequestMapping("/findByBrand")
    public String carsWithBrand(Model model, @RequestParam(value = "brand") String brand) {
        model.addAttribute("cars", carService.findByBrand(brand));
        return "carHome";
    }
}
