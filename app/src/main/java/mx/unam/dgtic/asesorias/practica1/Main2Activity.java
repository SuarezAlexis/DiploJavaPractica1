package mx.unam.dgtic.asesorias.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    TextView greetingTextView;
    TextView signTextView;
    ImageView signImageView;
    Typeface mayanTypeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();

        Log.d("DEBUG", "Main2Activity. Datos recibidos en bundle: { name: " + bundle.get("name") +
                ", surname: " + bundle.get("surname") +
                ", day: " + bundle.get("day") + "" +
                ", month: " + bundle.get("month") +
                ", year: " + bundle.get("year") + " }");

        mayanTypeface = Typeface.createFromAsset(getAssets(),"Mayan.ttf");
        greetingTextView = findViewById(R.id.greetingTextView);
        signTextView = findViewById(R.id.signTextView);
        signImageView = findViewById(R.id.signImageView);

        greetingTextView.setTypeface(mayanTypeface);
        signTextView.setTypeface(mayanTypeface);

        Calendar calendar = Calendar.getInstance();
        int years = calendar.get(Calendar.YEAR) - bundle.getInt("year");
        if(
            calendar.get(Calendar.MONTH) < bundle.getInt("month") ||
            ( calendar.get(Calendar.MONTH) == bundle.getInt("month") &&
              calendar.get(Calendar.DAY_OF_MONTH) < bundle.getInt("day") )
        ) {
                years--;
        }

        greetingTextView.setText(getResources().getText(R.string.greeting) + " " +
                bundle.get("name") + " " + bundle.get("surname") + "\n" +
                getResources().getString(R.string.your_age) + " " + years + " " + getResources().getString(R.string.years) + "\n" +
                getResources().getString(R.string.your_sign));

        int signImageResource = 0;
        int signStringResource = 0;
        switch(bundle.getInt("year")%12) {
            case 0:
                signImageResource = R.drawable.monkey;
                signStringResource = R.string.monkey;
                break;
            case 1:
                signImageResource = R.drawable.rooster;
                signStringResource = R.string.rooster;
                break;
            case 2:
                signImageResource = R.drawable.dog;
                signStringResource = R.string.dog;
                break;
            case 3:
                signImageResource = R.drawable.pig;
                signStringResource = R.string.pig;
                break;
            case 4:
                signImageResource = R.drawable.rat;
                signStringResource = R.string.rat;
                break;
            case 5:
                signImageResource = R.drawable.ox;
                signStringResource = R.string.ox;
                break;
            case 6:
                signImageResource = R.drawable.tiger;
                signStringResource = R.string.tiger;
                break;
            case 7:
                signImageResource = R.drawable.rabbit;
                signStringResource = R.string.rabbit;
                break;
            case 8:
                signImageResource = R.drawable.dragon;
                signStringResource = R.string.dragon;
                break;
            case 9:
                signImageResource = R.drawable.snake;
                signStringResource = R.string.snake;
                break;
            case 10:
                signImageResource = R.drawable.horse;
                signStringResource = R.string.horse;
                break;
            case 11:
                signImageResource = R.drawable.goat;
                signStringResource = R.string.goat;
                break;
        }
        signTextView.setText(signStringResource);
        signImageView.setImageResource(signImageResource);

    }
}
