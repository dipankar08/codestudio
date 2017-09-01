package in.peerreview.demo;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/********  Sample activity to be cloned...\
 import android.content.Intent;
 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Action(View v) {
        switch(v.getId()){
            case R.id.drawables:
                startActivity(new Intent(this, DrawableActivity.class));
                break;
            case R.id.jni:
                startActivity(new Intent(this, JNIActivity.class));
                break;
        }
    }
}
*********************/
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import in.peerreview.demo.External.AudioRecorder;
import in.peerreview.demo.External.RunTimePermission;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="Dipankar" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RunTimePermission.setup(this);
        RunTimePermission.askPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,null);
        RunTimePermission.askPermission(Manifest.permission.READ_EXTERNAL_STORAGE,null);
        RunTimePermission.askPermission(Manifest.permission.RECORD_AUDIO,null);

        AudioRecorder.setup(this);
        AudioRecorder.test();
    }
    public void Action(View v) {
        Class c=null;
        switch(v.getId()){
            case R.id.drawables:
                c = DrawableActivity.class;
                break;
            case R.id.jni:
                c = JNIActivity.class;
                break;
            case R.id.ui1:
                c = BluredActivity.class;
                break;
            case R.id.ui2:
                c = CustomViewActivity.class;
                break;
        }
        if(c !=null)
            startActivity(new Intent(this,c ));
    }
}
