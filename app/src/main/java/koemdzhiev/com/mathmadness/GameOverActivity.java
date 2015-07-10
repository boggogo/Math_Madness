package koemdzhiev.com.mathmadness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import koemdzhiev.com.mathmadness.utils.Constants;


public class GameOverActivity extends AppCompatActivity {
    private TextView mMathEquasion;
    private ImageView mPlayAgain;
    private ImageView mGoHome;
    private TextView mScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        mMathEquasion = (TextView)findViewById(R.id.mathEquasion);
        Intent intent = getIntent();
        mMathEquasion.setText(intent.getStringExtra(Constants.KEY_MATH_EQ));
        mPlayAgain = (ImageView)findViewById(R.id.playAgainBtn);
        mPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //play animations
                YoYo.with(Techniques.Pulse)
                        .duration(100)
                        .playOn(findViewById(R.id.playAgainBtn));
                Intent intent = new Intent(GameOverActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        mScore = (TextView)findViewById(R.id.score);
        mScore.setText("Score: "+intent.getIntExtra(Constants.KEY_SCORE,0));
        mGoHome = (ImageView)findViewById(R.id.goToHome);
        mGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //play animations
                YoYo.with(Techniques.Pulse)
                        .duration(100)
                        .playOn(findViewById(R.id.goToHome));
                Intent intent = new Intent(GameOverActivity.this,StartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_over, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}