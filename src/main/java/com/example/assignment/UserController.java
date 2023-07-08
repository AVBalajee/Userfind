package com.example.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * The UserController class is a REST controller that handles HTTP requests related to user operations.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    /**
     * The UserService instance used for handling user-related operations.
     */
    private final UserService userService;

    /**
     * Constructs a new UserController with the specified UserService.
     *
     * @param userService the UserService instance to be used
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a new user location data.
     *
     * @param userLocation the UserLocation object containing the user location data
     * @return a ResponseEntity containing the created UserLocation object in the response body
     */
    @PostMapping("/create_data")
    public ResponseEntity<UserLocation> createData(@RequestBody UserLocation userLocation) {
        UserLocation createdUserLocation = userService.createUser(userLocation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserLocation);
    }

    /**
     * Updates the user location data for the specified user ID.
     *
     * @param id the ID of the user whose location data needs to be updated
     * @param userLocation the UserLocation object containing the updated user location data
     * @return a ResponseEntity containing the updated UserLocation object in the response body
     */
    @PatchMapping("/update_data/{id}")
    public ResponseEntity<UserLocation> updateData(
            @PathVariable("id") Long id,
            @RequestBody UserLocation userLocation
    ) {
        UserLocation updatedUserLocation = userService.updateUser(id, userLocation);
        return ResponseEntity.ok(updatedUserLocation);
    }

    /**
     * Retrieves a list of nearest users based on the specified count.
     *
     * @param count the number of nearest users to retrieve
     * @return a ResponseEntity containing a list of UserLocation objects in the response body
     */
    @GetMapping("/get_users/{count}")
    public ResponseEntity<List<UserLocation>> getUsers(@PathVariable("count") int count) {
        List<UserLocation> users = userService.getNearestUsers(count);
        return ResponseEntity.ok(users);
    }
}
