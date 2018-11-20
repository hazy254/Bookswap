package projects.juma.bookswap;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.bumptech.glide.Glide;
import java.util.List;

/**
 * Created by Emmanuel Juma on 7/30/2016.
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder>{
    private LayoutInflater inflater;
    public Context context;
    List<Book> bookList;
    private ImageLoader imageLoader;



    public BookAdapter(Context context, List<Book> bookList) {

        inflater = LayoutInflater.from(context);
        this.context = context;
        this.bookList = bookList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.book_card, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    Book current = bookList.get(position);
        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(current.getCoverUrl(),ImageLoader.getImageListener(holder.cover, R.mipmap.ic_launcher,R.drawable.ic_menu_share));
        holder.cover.setImageUrl(current.getCoverUrl(), imageLoader);
        holder.title.setText(current.getTitle());
        holder.phonenumber.setText(current.getPhoneNumber());
       // holder.synopsis.setText(current.getSynopsis());
        holder.author.setText(current.getAuthor());
        holder.owner.setText(current.getOwner());



    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
       public TextView title, author, owner, phonenumber;
        NetworkImageView cover;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            author = (TextView) itemView.findViewById(R.id.author);
            phonenumber = (TextView) itemView.findViewById(R.id.phoneNum);
            owner = (TextView) itemView.findViewById(R.id.owner);
            cover = (NetworkImageView) itemView.findViewById(R.id.thumbnail);

        }


    }

}
