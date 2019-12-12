package mx.unam.dgtic.asesorias.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner monthSpinner;
    Button button;
    TextView titleTextView;
    TextView instructionTextView;
    EditText nameEditText;
    TextView nameTextView;
    EditText surnameEditText;
    TextView surnameTextView;
    EditText dayEditText;
    EditText yearEditText;
    TextView birthdayTextView;
    Typeface mayanTypeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mayanTypeface = Typeface.createFromAsset(getAssets(),"Mayan.ttf");

        monthSpinner = findViewById(R.id.monthSpinner);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.months, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(adapter);

        titleTextView = findViewById(R.id.titleTextView);
        instructionTextView = findViewById(R.id.instructionTextView);
        nameEditText = findViewById(R.id.nameEditText);
        nameTextView = findViewById(R.id.nameTextView);
        surnameEditText = findViewById(R.id.surnameEditText);
        surnameTextView = findViewById(R.id.surnameTextView);
        dayEditText = findViewById(R.id.dayEditText);
        yearEditText = findViewById(R.id.yearEditText);
        birthdayTextView = findViewById(R.id.birthdayTextView);
        button = findViewById(R.id.button);

        titleTextView.setTypeface(mayanTypeface);
        instructionTextView.setTypeface(mayanTypeface);
        nameTextView.setTypeface(mayanTypeface);
        surnameTextView.setTypeface(mayanTypeface);
        birthdayTextView.setTypeface(mayanTypeface);
        button.setTypeface(mayanTypeface);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DEBUG", "Se presionó el botón.");
                boolean invalid = false;
                if( nameEditText.getText().toString().isEmpty() ) {
                    nameEditText.setError(getResources().getString(R.string.nameError));
                    Log.d("DEBUG","Error: " + getResources().getString(R.string.nameError) );
                    invalid = true;
                }
                if( surnameEditText.getText().toString().isEmpty() ) {
                    surnameEditText.setError(getResources().getString(R.string.surnameError));
                    Log.d("DEBUG","Error: " + getResources().getString(R.string.surnameError) );
                    invalid = true;
                }
                if( dayEditText.getText().toString().isEmpty() ) {
                    dayEditText.setError(getResources().getString(R.string.dayError));
                    Log.d("DEBUG","Error: " + getResources().getString(R.string.dayError) );
                    invalid = true;
                }
                if( yearEditText.getText().toString().isEmpty()) {
                    yearEditText.setError(getResources().getString(R.string.yearError));
                    Log.d("DEBUG","Error: " + getResources().getString(R.string.yearError) );
                    invalid = true;
                }
                if(!invalid) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name",nameEditText.getText().toString());
                    bundle.putString("surname",surnameEditText.getText().toString());
                    bundle.putInt("day",Integer.parseInt(dayEditText.getText().toString()));
                    bundle.putInt("month",monthSpinner.getSelectedItemPosition());
                    bundle.putInt("year",Integer.parseInt(yearEditText.getText().toString()));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
}
