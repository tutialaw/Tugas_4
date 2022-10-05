package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import id.ac.polinema.intentexercise.model.User;

public class ProfileActivity extends AppCompatActivity {
    private Button btnview;
    private CircleImageView civprofil;
    private TextView tvfullname, tvnim, tvpass, tvconpass, tvhomep, tvaboutu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnview=findViewById(R.id.button_homepage);
        civprofil=findViewById(R.id.image_profile);

        tvfullname=findViewById(R.id.label_fullname);
        tvnim=findViewById(R.id.label_nim);
        tvhomep=findViewById(R.id.label_homepage);
        tvaboutu=findViewById(R.id.label_about);
//        tvpass=findViewById(R.id.text_password);
//        tvconpass=findViewById(R.id.text_confirm_password);

        Bundle extras=getIntent().getExtras();
        if (extras != null){
            if (extras.getString("hasil_profile")!=null){
                Uri myUri =Uri.parse(extras.getString("hasil_profile"));
                civprofil.setImageURI(myUri);
            }
            User user = extras.getParcelable("user");

            tvfullname.setText(user.getFullname());
            tvnim.setText(user.getNim());
            tvhomep.setText(user.getHomep());
            tvaboutu.setText(user.getAboutu());
        }else {
            Toast.makeText(this, "Intent is missing", Toast.LENGTH_SHORT).show();
        }

    }

    public void handleView (View view) {
        Uri url= Uri.parse(tvhomep.getText().toString());
        Intent intent = new Intent(Intent.ACTION_VIEW, url);
        startActivity(intent);
    }
}
