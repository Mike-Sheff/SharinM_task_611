package ru.netologia.sharinm_task_611;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Lifecycle";
    private static final String SAVED_KEY = "context_textview";
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        outputMessage(getString(R.string.textMessageOnCreate));

        if(savedInstanceState != null){
            textView.setText(savedInstanceState.getString(SAVED_KEY));
            outputMessage(getString(R.string.textMessageSaveInstanceState,"not"));

        } else {
            outputMessage(getString(R.string.textMessageSaveInstanceState,""));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        outputMessage(getString(R.string.textMessageOnStart));
    }

    @Override
    protected void onResume() {
        super.onResume();

        outputMessage(getString(R.string.textMessageOnResume));
    }

    @Override
    protected void onPause() {
        super.onPause();

        outputMessage(getString(R.string.textMessageOnPause));
    }

    @Override
    protected void onStop() {
        super.onStop();

        outputMessage(getString(R.string.textMessageOnStop));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        outputMessage(getString(R.string.textMessageOnDestroy));
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        outputMessage(getString(R.string.textMessageOnRestart));
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);

        outputMessage(getString(R.string.textMessageOnPostCreate));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        outputMessage(getString(R.string.textMessageOnPostResume));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        outputMessage(getString(R.string.textMessageOnKeyDown));

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        outputMessage(getString(R.string.textMessageOnKeyLongPress));

        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        outputMessage(getString(R.string.textMessageOnBackPressed));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(SAVED_KEY, textView.getText().toString());
        outputMessage(getString(R.string.textMessageOnSaveInstanceState));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        outputMessage(getString(R.string.textMessageOnRestoreInstanceState));
    }

    private void outputMessage(String text){
        text = getString(R.string.textMessage, text, this);
        textView.append("\n" + text);
        Log.d(TAG, text);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
