package id.ac.polinema.intentexercise;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import de.hdodenhof.circleimageview.CircleImageView;
import id.ac.polinema.intentexercise.model.User;

public class RegisterActivity extends AppCompatActivity {
    private Button btnok;
    private ImageView iveditfoto;
    private CircleImageView civprofil;
    private Uri imageUri;
    private TextInputEditText etfullname, etnim, etpass, etconpass, ethomep, etaboutu;

    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    private static final String USER_KEY = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnok=findViewById(R.id.button_ok);
        iveditfoto=findViewById(R.id.imageView);
        civprofil=findViewById(R.id.image_profile);

        etfullname=findViewById(R.id.text_fullname);
        etnim=findViewById(R.id.text_nim);
        etpass=findViewById(R.id.text_password);
        etconpass=findViewById(R.id.text_confirm_password);
        ethomep=findViewById(R.id.text_homepage);
        etaboutu=findViewById(R.id.text_about);

        iveditfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALLERY_REQUEST_CODE);
            }
        });

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                String sfullname = etfullname.getText().toString();
                String snim = etnim.getText().toString();
                String spass = etpass.getText().toString();
                String scopass = etconpass.getText().toString();
                String shomepage = ethomep.getText().toString();
                String sabout = etaboutu.getText().toString();

                User user = new User(sfullname, snim, spass, scopass, shomepage, sabout);

                Intent intent = new Intent(RegisterActivity.this, ProfileActivity.class);
                intent.putExtra(USER_KEY, user);
                intent.putExtra("hasil_profile",imageUri.toString());

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
            Toast.makeText(this,"Cancel input image", Toast.LENGTH_SHORT).show();
            return;
        }
        if (requestCode == GALLERY_REQUEST_CODE){
            if (data!=null){
                try {
                    imageUri=data.getData();
                    Bitmap bmp=MediaStore.Images.Media.getBitmap(this.getContentResolver(),imageUri);
                    civprofil.setImageBitmap(bmp);
                }
                catch (IOException e){
                    Toast.makeText(this, "Can't load Image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}