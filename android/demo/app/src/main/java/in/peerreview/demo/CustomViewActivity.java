package in.peerreview.demo;

/**
 * Created by ddutta on 9/1/2017.
 */

import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
public class CustomViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);
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