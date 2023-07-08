package com.example.assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing user locations.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructs a new UserService with the specified UserRepository.
     *
     * @param userRepository the repository used for user location operations
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Creates a new user location.
     *
     * @param userLocation the user location to be created
     * @return the created user location
     */
    public UserLocation createUser(UserLocation userLocation) {
        return userRepository.save(userLocation);
    }

    /**
     * Updates an existing user location with the specified ID.
     *
     * @param id the ID of the user location to be updated
     * @param userLocation the updated user location
     * @return the updated user location
     * @throws IllegalArgumentException if the user location with the given ID does not exist
     */
    public UserLocation updateUser(Long id, UserLocation userLocation) {
        UserLocation existingUserLocation = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user location id: " + id));

        existingUserLocation.setName(userLocation.getName());
        existingUserLocation.setLatitude(userLocation.getLatitude());
        existingUserLocation.setLongitude(userLocation.getLongitude());

        return userRepository.save(existingUserLocation);
    }

    /**
     * Retrieves a list of nearest users based on the given count.
     *
     * @param count the number of nearest users to retrieve
     * @return a list of nearest user locations
     */
    public List<UserLocation> getNearestUsers(int count) {
        List<UserLocation> users = userRepository.findAll();
        users.forEach(user -> user.setDistanceFromOrigin(calculateDistance(user.getLatitude(), user.getLongitude(), 0, 0)));
        users.sort(Comparator.comparingDouble(UserLocation::getDistanceFromOrigin));
        return users.stream().limit(count).collect(Collectors.toList());
    }

    /**
     * Calculates the distance between two coordinates using the Euclidean distance formula.
     *
     * @param lat1 the latitude of the first coordinate
     * @param lon1 the longitude of the first coordinate
     * @param lat2 the latitude of the second coordinate
     * @param lon2 the longitude of the second coordinate
     * @return the distance between the two coordinates
     */
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        return Math.sqrt(Math.pow((lat2 - lat1), 2) + Math.pow((lon2 - lon1), 2));
    }
}

