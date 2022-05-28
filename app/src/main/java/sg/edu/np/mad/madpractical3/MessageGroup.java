package sg.edu.np.mad.madpractical3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.acl.Group;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Button group1Button = findViewById(R.id.Group1);
        group1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment, Group1.class, null )
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        Button group2Button = findViewById(R.id.Group2);
        group2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment, Group2.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });
    }
}