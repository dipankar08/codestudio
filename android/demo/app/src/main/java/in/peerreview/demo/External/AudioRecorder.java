package in.peerreview.demo.External;

/**
 * Created by ddutta on 9/1/2017.
 */
import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;

public class AudioRecorder {
    private static final String TAG = "MyOkHttp";
    private static Activity mContext;
    public static void setup(Activity cx){
        mContext = cx;
    }
    /***********************************************************************************************
     * Please Write your logic Here.
     **********************************************************************************************/
    private MediaRecorder recorder = new MediaRecorder();

    private File outfile = null;
    boolean m_isRecoding = false;

    public AudioRecorder(){}

    public void startRecording(String audioFile) {
        String state = android.os.Environment.getExternalStorageState();
        if(!state.equals(android.os.Environment.MEDIA_MOUNTED))  {
           Log.d(TAG, "SD Card is not mounted.  It is " + state + ".");
        }
/*
        // make sure the directory we plan to store the recording in exists
        File directory = new File("/").getParentFile();
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException("Path to file could not be created.");
        }*/
        if(m_isRecoding == true){
            recorder.stop();
        }

        try{
            File storageDir = new File(Environment.getExternalStorageDirectory(), "/audio/");
            storageDir.mkdir();
            outfile=File.createTempFile(audioFile, ".wav",storageDir);
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.RAW_AMR);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            recorder.setOutputFile(outfile.getAbsolutePath());
        }catch(IOException e){
            e.printStackTrace();
            return;
        }
        try{
            recorder.prepare();
        }catch(IllegalStateException e){
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        recorder.start();
        m_isRecoding = true;
    }
    public void stop() throws IOException {
        recorder.stop();
        recorder.release();
    }
    /***********************************************************************************************
     * Please write a sample text to confirm this module is working fine.
     **********************************************************************************************/
    public static void test(){
        //write test
        Log.d(TAG,"Staring Test....");
        AudioRecorder a = new AudioRecorder();
        a.startRecording("hello");
        Log.d(TAG,"Ending Test....");
    }
}