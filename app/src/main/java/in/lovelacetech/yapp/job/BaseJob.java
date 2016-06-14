package in.lovelacetech.yapp.job;

import android.support.annotation.IntDef;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import in.lovelacetech.yapp.job.exception.NetworkException;

/**
 * Created by Tioammar
 */
abstract public class BaseJob extends Job {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({UI_HIGH, BACKGROUND})
    public @interface Priority {}

    public static final int UI_HIGH = 2;
    public static final int BACKGROUND = 1;

    public BaseJob(Params params) {
        super(params);
    }

    // network check
    protected boolean shouldRetry(Throwable throwable){
        if (throwable instanceof NetworkException){
            NetworkException exception = (NetworkException) throwable;
            return exception.shoudRetry();
        }
        return false;
    }
}
