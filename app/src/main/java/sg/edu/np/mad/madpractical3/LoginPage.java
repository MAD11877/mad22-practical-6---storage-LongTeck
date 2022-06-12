package sg.edu.np.mad.madpractical3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        FirebaseDatabase fb = FirebaseDatabase.getInstance("https://week6practical-77851-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference ref = fb.getReference("Users");

        EditText inputName = findViewById(R.id.GetUsername);
        EditText inputPassword = findViewById(R.id.GetPassword);
        Button loginButton = findViewById(R.id.LoginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();
                String password = inputPassword.getText().toString();


                ref.child("mad").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String checkPassword = snapshot.child("password").getValue(String.class);
                        String checkName = snapshot.child("username").getValue(String.class);

                        // check for correct password and username
                        if (checkPassword.equals(password) && checkName.equals(name)) {
                            Intent toList = new Intent(LoginPage.this, ListActivity.class);
                            startActivity(toList);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
    }
}