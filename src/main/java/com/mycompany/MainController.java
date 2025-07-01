/** Clasa pentru pornirea aplicatiei
 * @author Paun Alexandra
 * @version 10 ianuarie 2025
 */
package com.mycompany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String showHomePage() {
        return "index";
    }
}
