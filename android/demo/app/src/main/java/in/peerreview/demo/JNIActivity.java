package in.peerreview.demo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class JNIActivity extends AppCompatActivity {
    TextView resultsView;
    Button button;
    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni);

        resultsView = (TextView) findViewById(R.id.textView1);
        button = (Button) findViewById(R.id.buttonSubmit);
        inputText = (EditText) findViewById(R.id.editText1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long input;
                try {
                    input = Long.parseLong(inputText.getText().toString());
                } catch (NumberFormatException e) {
                    resultsView.setText("Please input valid number.");
                    return;
                }
                resultsView.setText("Calculating...");
                new CalculateFibonacci().execute(input);
            }
        });
    }
    private class CalculateFibonacci extends AsyncTask<Long, Integer, String> {

        @Override
        protected String doInBackground(Long... inputs) {
            long input = inputs[0];
            long result, start, stop;
            String out = new String();

            start = System.currentTimeMillis();
            result = FibLib.fibJ(input);
            stop = System.currentTimeMillis();
            out += String.format("Java Recursive [%d] took: %d ms\n", result, stop-start);

            start = System.currentTimeMillis();
            result = FibLib.fibJI(input);
            stop = System.currentTimeMillis();
            out += String.format("Java Iterative [%d] took: %d ms\n", result, stop-start);

            start = System.currentTimeMillis();
            result = FibLib.fibN(input);
            stop = System.currentTimeMillis();
            out += String.format("Native Recursive [%d] took: %d ms\n", result, stop-start);

            start = System.currentTimeMillis();
            result = FibLib.fibNI(input);
            stop = System.currentTimeMillis();
            out += String.format("Native Iterative [%d] took: %d ms", result, stop-start);

            return out;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            resultsView.setText(result);
        }

    }
}

class FibLib {
    public static long fibJ (long input) {
        if (input <= 0)
            return 0;
        if (input == 1)
            return 1;
        return fibJ(input - 1) + fibJ(input - 2);
    }
    public static long fibJI (long input) {
        long previous = - 1;
        long result = 1;
        for ( int i = 0; i <= input; i++ ) {
            long sum = result + previous;
            previous = result;
            result = sum;
        }
        return result;
    }
    // Loading Native implementation
    static {
        System.loadLibrary("fib");
    }
    // Native implementation - recursive
    public static native long fibN(long n);
    // Native implementation - iterative
    public static native long fibNI(long n);
}

