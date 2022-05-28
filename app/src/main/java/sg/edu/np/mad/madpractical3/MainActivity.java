package sg.edu.np.mad.madpractical3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> userList = ListAdapter.data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*DBHandler db = new DBHandler(this);
        for(int i=0; i < 20; i++){
            User user = userList.get(i);
            db.insertMsg(user);
        }
        User m = new User("joe", "hi", 0, false);
        db.insertMsg(m);*/

        Intent temp = getIntent();
        Integer id = temp.getIntExtra("Id", 0);
        User user = userList.get(id);
        initFllwBtn(user);

        TextView title = findViewById(R.id.Title);
        title.setText(user.Name);

        TextView desc = findViewById(R.id.Text);
        desc.setText(user.Description);

        TextView txt = findViewById(R.id.Follow);
        Button followButton = findViewById(R.id.Follow);

        DBHandler db = new DBHandler(this);
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, txt.getText() + "ed", Toast.LENGTH_SHORT)
                        .show();
                if(user.Followed == false){
                    txt.setText("Unfollow");
                    user.Followed = true;
                }
                else{
                    txt.setText("Follow");
                    user.Followed = false;
                }
                db.updateUser(user);
            }
        });




        Button messageButton = findViewById(R.id.Message);
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messagePage = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(messagePage);
            }
        });
    }

    public void initFllwBtn(User user) {
        Button followButton = findViewById(R.id.Follow);
        if (user.Followed) {
            followButton.setText("Unfollow");
        } else {
            followButton.setText("Follow");
        }
    }


        //onclick method
    /*public void OnCLick(View v){
        TextView txt = findViewById(R.id.Follow);
        Button followButton = findViewById(R.id.Follow);
        Toast.makeText(MainActivity.this, txt.getText() + "ed", Toast.LENGTH_SHORT)
                .show();

        if (user.Followed == false) {
            txt.setText("Follow");
            user.Followed = true;
        } else {
            txt.setText("Unfollow");
            user.Followed = false;
        }
    }*/
}
