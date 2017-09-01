package in.peerreview.demo.External;

import android.app.Activity;
import android.util.Log;

/**
 * Created by ddutta on 9/1/2017.
 */
public class SampleLib {
    private static final String TAG = "MyOkHttp";
    private static Activity mContext;
    public static void setup(Activity cx){
        mContext = cx;
    }
    /***********************************************************************************************
     * Please Write your logic Here.
     **********************************************************************************************/

    /***********************************************************************************************
     * Please write a sample text to confirm this module is working fine.
     **********************************************************************************************/
    public static void test(){
        //write test
        Log.d(TAG,"Staring Test....");
        Log.d(TAG,"Ending Test....");
    }

}
