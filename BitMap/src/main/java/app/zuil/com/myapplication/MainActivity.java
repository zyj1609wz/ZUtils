package app.zuil.com.myapplication;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById( R.id.image );

        findViewById( R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap rawBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.a1  ) ;
                imageView.setImageBitmap( rawBitmap );
            }
        });
    }
}
