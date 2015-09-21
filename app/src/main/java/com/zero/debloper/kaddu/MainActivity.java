package com.zero.debloper.kaddu;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, ProfileRecyclerViewActivity.class));
            return true;
        } else if (id == R.id.action_voice_command_help) {
            startActivity(new Intent(this, VoiceCommandHelpActivity.class));
            return true;
        } else if (id == R.id.action_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Activity Results handler
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        // if it’s speech recognition results
        // and process finished ok
        if (requestCode == SystemData.VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {

            // receiving a result in string array
            // there can be some strings because sometimes speech recognizing inaccurate
            // more relevant results in the beginning of the list
            ArrayList matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            // in “matches” array we holding a results... let’s show the most relevant
            if (matches.size() > 0) {
                //Toast.makeText(this, (CharSequence) matches.get(0), Toast.LENGTH_LONG).show();
                DynamicProfileManager.getInstance(getApplicationContext()).parseVoiceCommand((String) matches.get(0));
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onMicButtonClick(View view) {
        SpeechRecognitionHelper.run(this);
    }
}
