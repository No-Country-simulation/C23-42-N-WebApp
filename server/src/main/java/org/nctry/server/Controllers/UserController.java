package org.nctry.server.Controllers;

import org.nctry.server.Utilities.Pages.PaginationUtils;
import org.nctry.server.services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.nctry.server.Controllers.ApiPaths.ROOT;


@RestController
@RequestMapping(ROOT + "/user")
public class UserController {
    private final UserService userService;
    private Map<String, Object> data;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAll(
            @RequestParam(value = "pageNumber", defaultValue = PaginationUtils.DEFECT_PAGE_NUMBER, required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = PaginationUtils.DEFECT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = PaginationUtils.DEFECT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = PaginationUtils.DEFECT_SORT_DIRECTION, required = false) String sortDir)
    {
        data = new HashMap<>();

        data.put("DATA :", userService.findAll(pageNumber, pageSize, sortBy, sortDir));

        return ResponseEntity.ok(data);
    }

    @GetMapping("/get/username")
    public ResponseEntity<Object> getUserByUsername(@RequestParam String username) {
        data = new HashMap<>();
        data.put("Usuario Encontrado: ", userService.findByUsername(username));
        return ResponseEntity.ok(data);
    }

    /*@GetMapping("/get/email")
    public ResponseEntity<Object> getUserByEmail(@RequestParam String email) {
        data = new HashMap<>();
        data.put("Usuario Encontrado: ", userService.findByEmail(email));
        return ResponseEntity.ok(data);
    }*/

    @GetMapping("/get/id")
    public ResponseEntity<Object> getUserById(@RequestParam Long id) {
        data = new HashMap<>();
        data.put("UserFound", userService.findById(id));
        return ResponseEntity.ok(data);
    }
}
