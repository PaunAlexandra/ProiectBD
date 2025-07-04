/** Clasa pentru gestionarea cererilor HTTP si pentru mapare
 * @author Paun Alexandra
 * @version 10 ianuarie 2025
 */
package com.mycompany.lista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ListaController {

    @Autowired
    private ListaService service;

    @GetMapping("/lista")
    public String showLista(@RequestParam(required = false) String field,
                            @RequestParam(required = false) String direction,
                            Model model) {
        List<Lista> listItems;

        if ("prioritate".equalsIgnoreCase(field) && "asc".equalsIgnoreCase(direction)) {
            listItems = service.sortByPrioritateAsc();
        } else if ("prioritate".equalsIgnoreCase(field) && "desc".equalsIgnoreCase(direction)) {
            listItems = service.sortByPrioritateDesc();
        } else if ("pret".equalsIgnoreCase(field) && "asc".equalsIgnoreCase(direction)) {
            listItems = service.sortByPretAsc();
        } else if ("pret".equalsIgnoreCase(field) && "desc".equalsIgnoreCase(direction)) {
            listItems = service.sortByPretDesc();
        } else {
            listItems = service.sortByPrioritateAsc(); // Default sortare
        }

        model.addAttribute("listItems", listItems);
        return "lista";
    }

    @GetMapping("/lista/new")
    public String showNewForm(Model model) {
        model.addAttribute("lista", new Lista());
        model.addAttribute("pageTitle", "Adaugă un obiect nou");
        return "lista_form";
    }

    @PostMapping("/lista/save")
    public String saveItem(Lista lista, RedirectAttributes ra) {
        service.save(lista);
        ra.addFlashAttribute("message", "Obiectul a fost adăugat cu succes.");
        return "redirect:/lista";
    }

    @GetMapping("/lista/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Lista lista = service.get(id);
            model.addAttribute("lista", lista);
            model.addAttribute("pageTitle", "Edit Item (ID: " + id + ")");

            return "lista_form";
        } catch (ListaNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/lista";
        }
    }

    @GetMapping("/lista/delete/{id}")
    public String deleteItem(@PathVariable Long id, RedirectAttributes ra) {
        try {
            service.delete(id); // Șterge elementul cu ID-ul specificat
            ra.addFlashAttribute("message", "Obiectul cu  ID " + id + " a fost șters cu succes.");
        } catch (ListaNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/lista"; // Redirecționează înapoi la lista principală
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes ra) {
        if ("myusername".equals(username) && "mypassword".equals(password)) {
            return "redirect:/lista" ;
        } else {
            ra.addFlashAttribute("error", "Nume de utilizator sau parolă incorectă.");
            return "redirect:/";
        }
    }

    @RestController
    @RequestMapping("/api/lista")
    public class ListaApiController {

        @Autowired
        private ListaService service;

        @GetMapping
        public List<Lista> getAllItems() {
            return service.getAll();
        }
    }
}
