package in.peerreview.demo;

/**
 * Created by ddutta on 9/1/2017.
 */
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import jp.wasabeef.blurry.Blurry;

public class BluredActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blured);
        ViewGroup rootView = (ViewGroup) this.findViewById(R.id.root_view);
        //Blurry.with(this).radius(25).sampling(2).onto((ViewGroup) ));
        //Blurry.with(this).radius(10).sampling(8).color(Color.argb(66, 255, 255, 0)).async().onto(rootView);
        Blurry.with(this) .radius(25) .sampling(2) .async() .animate(500) .onto((ViewGroup) findViewById(R.id.root_view));
    }
}
