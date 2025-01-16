package Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola")
public class ControllerPrueba {
    @GetMapping("/")
    public String mundo() {
        return "mundo";
    }
}
