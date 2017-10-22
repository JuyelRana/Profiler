package dreamycoding.com.profiler.data.scheduler;

import dreamycoding.com.profiler.util.BaseSchedulerProvider;
import dreamycoding.com.profiler.util.ImmediateSchedulerProvider;

/**
 * Get the Immediate Scheduler for tests
 * Created by JuyelRana on 10/21/2017.
 */

public class SchedulerInjection {

    public static BaseSchedulerProvider provideSchedulerProvider() {
        return ImmediateSchedulerProvider.getInstance();
    }
}
