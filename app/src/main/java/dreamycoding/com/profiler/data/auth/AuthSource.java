package dreamycoding.com.profiler.data.auth;



import io.reactivex.Completable;
import io.reactivex.Maybe;

/**
 * Created by JuyelRana on 10/21/2017.
 */

public interface AuthSource {

    //Completable is rxjava
    Completable createAccount(Credentials credentials);

    Completable attemptLogin(Credentials credentials);

    Completable deleteUser();

    Maybe<User> getUser();

    Completable logUserOut();

    Completable reauthenticateUser(String password);

    void setReturnFail(boolean bool);
}
