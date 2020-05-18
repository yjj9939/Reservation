package sg.edu.rp.c346.id18054367.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    Button btnReserve;
    Button btnReset;
    EditText name;
    EditText mobile;
    EditText pax;
    DatePicker dp;
    TimePicker tp;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnReserve = findViewById(R.id.btnReserve);
        btnReset = findViewById(R.id.btnReset);
        name = findViewById(R.id.nameText);
        mobile = findViewById(R.id.phoneText);
        pax = findViewById(R.id.paxText);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cb = findViewById(R.id.checkBox);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smoking = "";

                if (cb.isChecked()){
                    smoking = "smoking area";

                } else {
                    smoking = "non-smoking area";
                }


                String enteredName = name.getText().toString();
                String mobileNum = mobile.getText().toString();
                String nop = pax.getText().toString();
                String message = String.format("%s with the Mobile Number of %s with %s amount of people reserved a %s, on the %02d/%02d/%02d %02d:%02d.", enteredName, mobileNum, nop, smoking, dp.getDayOfMonth(), dp.getMonth()+1, dp.getYear(), tp.getCurrentHour(), tp.getCurrentMinute());

                Context context = getApplicationContext();

                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, message, duration);
                toast.show();

            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                mobile.setText("");
                pax.setText("");
                cb.setChecked(false);
                dp.updateDate(2020,5,1);
                tp.setCurrentHour(20);
                tp.setCurrentMinute(30);


            }
        });



    }
}
