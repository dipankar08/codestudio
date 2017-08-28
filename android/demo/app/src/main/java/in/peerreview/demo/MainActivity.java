package in.peerreview.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
