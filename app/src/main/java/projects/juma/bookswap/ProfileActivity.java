//package projects.juma.bookswap;
//
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.net.Uri;
//import android.os.AsyncTask;
//import android.provider.MediaStore;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Base64;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.HashMap;
//
//public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
//    private Button buttonChoose;
//    private Button buttonFinish;
//    public static final String UPLOAD_URL="http://www.apphive.co.ke/Juma_Profiles/upload.php";
//    public static final String UPLOAD_KEY="image";
//    private int PICK_IMAGE_REQUEST = 1;
//    private EditText UserName;
//    private EditText UserNumber;
//    private ImageView ProfilePic;
//    private Uri filePath;
//    private Bitmap bitmap;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile);
//        buttonChoose = (Button) findViewById(R.id.btnProfPic);
//        buttonFinish = (Button) findViewById(R.id.btnFinish);
//        ProfilePic = (ImageView) findViewById(R.id.profPic);
//        UserName = (EditText) findViewById(R.id.userName);
//        UserNumber = (EditText) findViewById(R.id.userNum);
//
//        buttonFinish.setOnClickListener(this);
//        buttonChoose.setOnClickListener(this);
//
//    }
//    private void showFileChooser(){
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent,"Select Picture"), PICK_IMAGE_REQUEST);
//
//    }
//    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//
//            filePath = data.getData();
//            try {
//                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
//                ProfilePic.setImageBitmap(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    public String getStringImage(Bitmap bmp){
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//        byte[] imageBytes = baos.toByteArray();
//        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
//        return encodedImage;
//    }
//    private void uploadImage(){
//        class UploadImage extends AsyncTask<Bitmap,Void,String>{
//
//            ProgressDialog loading;
//            RequestHandler rh = new RequestHandler();
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//                loading = ProgressDialog.show(ProfileActivity.this, "Uploading...", null,true,true);
//            }
//
//            @Override
//            protected void onPostExecute(String s) {
//                super.onPostExecute(s);
//                loading.dismiss();
//                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            protected String doInBackground(Bitmap... params) {
//                Bitmap bitmap = params[0];
//                String uploadImage = getStringImage(bitmap);
//
//                HashMap<String,String> data = new HashMap<>();
//
//                data.put(UPLOAD_KEY, uploadImage);
//                String result = rh.sendPostRequest(UPLOAD_URL,data);
//
//                return result;
//            }
//
//        }
//        UploadImage ui = new UploadImage();
//        ui.execute(bitmap);
//        Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
//        ProfileActivity.this.startActivity(intent);
//    }
//
//
//
//    @Override
//    public void onClick(View v) {
//        if(v==buttonChoose){
//            showFileChooser();
//        }
//        if (v==buttonFinish){
//            uploadImage();
//        }
//    }
//}
