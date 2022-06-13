package sg.edu.np.mad.madpractical3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    ArrayList<User> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        DBHandler db = new DBHandler(this);

        Random rand = new Random();
        if (db.getUsers().size() == 0){
            for(int i=0; i < 20; i++){
                String name = "Name" + rand.nextInt();
                String description = "Description " + rand.nextInt();
                int id = i;
                boolean followed = rand.nextBoolean();
                User user = new User(name, description, id, followed);
                //data.add(user);
                db.insertMsg(user);
            }
        }
        data = db.getUsers();

        RecyclerView rv = findViewById(R.id.recyclerView);
        ListAdapter adapter = new ListAdapter(ListActivity.this, data);
        LinearLayoutManager layout = new LinearLayoutManager(this);

        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);

    }

}