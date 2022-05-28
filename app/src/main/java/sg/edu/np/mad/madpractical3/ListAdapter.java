package sg.edu.np.mad.madpractical3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListAdapter
        extends RecyclerView.Adapter<ListViewHolder> {

    public static ArrayList<User> data;
    Context c;
    public ListAdapter(Context c, ArrayList<User> data){
        this.data = data;
        this.c =c;
    }

    @Override
    public int getItemViewType(int position) {
        User user = data.get(position);
        if (user.Name.substring(user.Name.length() - 1).equals("7")){
            return 0;
        }
        else return 1;
/*        return (user.Name.substring(user.Name.length() - 1) .equals("7")) ? 0 : 1;*/
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;
        if (viewType == 1)
            item = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_layout,null, false);
        else
            item = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.last7_layout, parent, false);
        return new ListViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        User context  = data.get(position);
        holder.name.setText(context.Name);
        holder.description.setText(context.Description);


        holder.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(c);
                b.setTitle("Profile")
                        .setMessage(context.Name)
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent mainPage = new Intent(c, MainActivity.class);
                                mainPage.putExtra("Id", context.Id);
                                c.startActivity(mainPage);
                            }
                        });
                b.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
