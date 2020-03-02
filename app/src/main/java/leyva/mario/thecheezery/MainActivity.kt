package leyva.mario.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //Codigo para iniciar otra activity
        btnGetStarted.setOnClickListener{
            var intent = Intent(this,menuActivity::class.java)
            startActivity(intent)

        }
    }


}
