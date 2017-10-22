package dreamycoding.com.profiler.data;

import dreamycoding.com.profiler.data.auth.User;
import dreamycoding.com.profiler.data.database.Profile;

/**
 * Created by JuyelRana on 10/21/2017.
 */

public class GenericTestData {

    public static String getValidEmail() {
        return "juyel@example.com";
    }

    public static String getInvalidEmail() {
        return "juyelexample.com";
    }

    public static String getName() {
        return "juyel";
    }

    public static String getValidPassword() {
        return "123456";
    }

    public static String getInvalidPassword() {
        return "12345";
    }

    public static User getUser() {
        return new User("juyel@example.com", "someID");
    }

    public static Profile getProfile() {
        return new Profile(
                "",
                "",
                "someId",
                "juyel@example.com",
                "",
                "Juyel"
        );
    }

    public static String getPhotoUri() {
        return "juyel/example.jpeg";
    }
}
