package sg.edu.np.mad.madpractical3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder{
    TextView name;
    TextView description;
    ImageView profile;

    public ListViewHolder(View item){
        super(item);

        name = item.findViewById(R.id.username);
        description = item.findViewById(R.id.description);
        profile = item.findViewById(R.id.profile);

    }
}
