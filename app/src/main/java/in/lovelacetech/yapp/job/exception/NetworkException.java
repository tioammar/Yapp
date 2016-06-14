package in.lovelacetech.yapp.job.exception;

/**
 * Created by Tioammar.
 */
public class NetworkException extends RuntimeException {

    private int mErrorCode;

    public NetworkException(int err){
        mErrorCode = err;
    }

    public boolean shoudRetry(){
        return mErrorCode < 400 || mErrorCode > 499;
    }
}
