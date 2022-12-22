package app.pavankumar.otpverification;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mauth;
    TextView txt;
    LinearLayout logout;
    ImageView img;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=findViewById(R.id.textView2);
        //logout=(LinearLayout) findViewById(R.id.logout1);
        mauth=FirebaseAuth.getInstance();
        img=findViewById(R.id.imageView9);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), OtpSendActivity.class));
                mauth.signOut();
            }
        });
        txt.setText(mauth.getCurrentUser().getPhoneNumber().toString());

        Toast.makeText(getApplicationContext(), mauth.getCurrentUser().getPhoneNumber().toString(), Toast.LENGTH_LONG).show();
    }
}