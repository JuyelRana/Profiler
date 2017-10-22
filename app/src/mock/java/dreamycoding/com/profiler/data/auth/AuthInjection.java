package dreamycoding.com.profiler.data.auth;

/**
 * Created by JuyelRana on 10/21/2017.
 */

public class AuthInjection {

    public static AuthSource provideAuthSource() {
        return FakeAuthService.getInstance();
    }
}
