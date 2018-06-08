package gustlantidojp.guesswho;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.view.View;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.provider.MediaStore;
import android.net.Uri;

public class GuessWho_Main extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView imgToLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guess_who_layout);
        imgToLoad = (ImageView) findViewById(R.id.imageView);
    }

    public void CameraButton(View v)
    {
        dispatchTakePictureIntent();
    }

    public void onClickGallery(View v)
    {
        loadImage();
    }

    private void loadImage()
    {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent, 100);
    }

    private void dispatchTakePictureIntent()
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {


        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            imageView.setImageBitmap(imageBitmap);
        }
        else if(requestCode == 100 && resultCode == RESULT_OK )
        {
            Uri path=data.getData();
            imgToLoad.setImageURI(path);
        }
    }
}
