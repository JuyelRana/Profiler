package dreamycoding.com.profiler.util;

import io.reactivex.Scheduler;

/**
 * Created by JuyelRana on 10/21/2017.
 */

public interface BaseSchedulerProvider {
    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
