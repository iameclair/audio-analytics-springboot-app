package uk.co.audioanalytics.challenge.services;

import org.springframework.stereotype.Service;
import uk.co.audioanalytics.challenge.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ${Eclair} on 5/21/2019.
 */
@Service
public class UserService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "James Francis Cameron", "64", "Filmmaker",
                "https://en.wikipedia.org/wiki/James_Cameron#/media/File:James_Cameron_October_2012.jpg"));
        users.add(new User(2, "Barack Hussein Obama", "57", "Retired",
                "https://upload.wikimedia.org/wikipedia/commons/8/8d/President_Barack_Obama.jpg"));
        users.add(new User(3, "Aubrey Drake Graham", "32", "Rapper",
                "https://en.wikipedia.org/wiki/Drake_(musician)#/media/File:Drake_at_the_Velvet_Underground_-_2017_(35986086223)_(cropped).jpg"));
        users.add(new User(4, "Patrice Émery Lumumba", "35", "Dead",
                "https://en.wikipedia.org/wiki/Patrice_Lumumba#/media/File:Patrice_Lumumba,_1960.jpg"));
    }

    public List<User> fidAll(){
        return users;
    }
    public User save(User user){
        Integer id = users.size()+1;
        if(user.getId()== null){
            user.setId(id);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        Optional<User> first = users.stream().filter(user -> user.getId() == id).findFirst();
        return first.orElse(null);
    }
}
