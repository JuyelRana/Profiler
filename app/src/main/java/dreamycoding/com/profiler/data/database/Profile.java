package dreamycoding.com.profiler.data.database;

/**
 * Created by JuyelRana on 10/21/2017.
 */

public class Profile {
    private String bio;
    private String interests;
    private String uid;
    private String email;
    private String photoURL;
    private String name;

    public Profile(String bio, String interests, String uid, String email, String photoURL, String name) {
        this.bio = bio;
        this.interests = interests;
        this.uid = uid;
        this.email = email;
        this.photoURL = photoURL;
        this.name = name;
    }

    public Profile() {
        //for firebase
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
