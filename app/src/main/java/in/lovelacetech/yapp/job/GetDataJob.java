package in.lovelacetech.yapp.job;

import android.util.Log;

import com.path.android.jobqueue.Params;

/**
 * Created by Tioammar
 */
public class GetDataJob extends BaseJob {

    private static final String TAG = GetDataJob.class.getSimpleName();

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
    }

    @Override
    protected void onCancel() {
        Log.e(TAG, "job cancelled");
    }
}
