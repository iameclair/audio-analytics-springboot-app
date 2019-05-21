package uk.co.audioanalytics.challenge.model;

/**
 * Created by ${Eclair} on 5/21/2019.
 */
public class User {
    private Integer id;
    private String name;
    private String age;
    private String occupation;
    private String image;

    public User(Integer id, String name, String age, String occupation, String image) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
