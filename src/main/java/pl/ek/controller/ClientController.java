package pl.ek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.ek.domain.Client;
import pl.ek.services.ClientService;

import javax.validation.Valid;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/showAll")
    public String findAll(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "clientHome";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "clientForm";
        } else {
            clientService.save(client);
            model.addAttribute("clients", clientService.findAll());
            return "clientHome";
        }
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("client", new Client());
        return "clientForm";
    }

    @RequestMapping("/showFinder")
    public String findBySurname(Model model) {
        model.addAttribute("client", new Client());
        return "clientFinder";
    }

    @RequestMapping("/findBySurname")
    public String clientWithSurname(Model model, @RequestParam(value = "surname") String surname) {
        model.addAttribute("clients", clientService.findBySurname(surname));
        return "clientHome";
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam(value = "id") Long id) {
        clientService.delete(id);
        model.addAttribute("clients", clientService.findAll());
        return "clientHome";
    }

    @RequestMapping("/details")
    public String showDetails(Model model, @RequestParam(value = "id") Long id) {
        model.addAttribute("client", clientService.findOne(id));
        return "clientDetails";
    }

    @RequestMapping("/rentals")
    public String showrentals(Model model, @RequestParam(value = "id") Long id) {
        model.addAttribute("client", clientService.findOne(id));
        return "clientRentals";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "clientUpdate";
        } else {
            clientService.update(client);
            model.addAttribute("clients", clientService.findAll());
            return "clientHome";
        }
    }

    @GetMapping("/update")
    public String showFormUpdate(Model model, @RequestParam(value = "id") Long id) {
        model.addAttribute("client", clientService.findOne(id));
        return "clientUpdate";
    }

}
