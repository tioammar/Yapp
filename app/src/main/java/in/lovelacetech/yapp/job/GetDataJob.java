package in.lovelacetech.yapp.job;

import android.util.Log;

import com.path.android.jobqueue.Params;

import de.greenrobot.event.EventBus;
import in.lovelacetech.yapp.event.GetDataEvent;

/**
 * Created by Tioammar
 */
public class GetDataJob extends BaseJob {

    private static final String TAG = GetDataJob.class.getSimpleName();
    private EventBus mBus;

    public GetDataJob(@Priority int priority) {
        super(new Params(priority).persist());
    }

    @Override
    public void onAdded() {
        Log.d(TAG, "job added...");
    }

    @Override
    public void onRun() throws Throwable {

        Log.d(TAG, "Database input, job finished");

        // send message to main thread
        mBus.post(new GetDataEvent());
    }

    @Override
    protected void onCancel() {
        Log.e(TAG, "job cancelled");
    }
}
