package projects.juma.bookswap;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;


public class BookInfoActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private NetworkImageView bookcover;
    private TextView author, authorname, owner, ownername;
    private ImageLoader imageLoader;
    List<Book> bookList;
    private Context context;
    private Button btncontact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_book_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bookcover = (NetworkImageView) findViewById(R.id.bookcover);
        author = (TextView) findViewById(R.id.author);
        authorname = (TextView) findViewById(R.id.authorname);
        owner = (TextView) findViewById(R.id.owner);
        ownername = (TextView) findViewById(R.id.ownername);
        btncontact = (Button) findViewById(R.id.btnContact);

        String author1 = getIntent().getExtras().getString("Author");
        String owner1 = getIntent().getExtras().getString("Owner");
        String coverurl = getIntent().getExtras().getString("Cover");
        String position = getIntent().getExtras().getString("position");
        final String title = getIntent().getExtras().getString("Title");
        final String phonenum = getIntent().getExtras().getString("Number");
        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(coverurl,ImageLoader.getImageListener(bookcover,R.mipmap.ic_launcher,R.drawable.ic_menu_share));

        bookcover.setImageUrl(coverurl,imageLoader);
        authorname.setText(author1);
        ownername.setText(owner1);

        btncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage("0713359996",null,"Hi, Found your book "+ title+" Please would like ",null,null);

            }
        });

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent myIntent = new Intent(this, MainActivity.class);
            this.startActivity(myIntent);
        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_find) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_logout) {
            Intent myIntent = new Intent(this, LoginActivity.class);
            myIntent.putExtra("logout", "myMethod");
            startActivity(myIntent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
