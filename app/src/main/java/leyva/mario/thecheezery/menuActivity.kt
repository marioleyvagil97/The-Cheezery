package leyva.mario.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class menuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        btnColdDrink.setOnClickListener{
            var intent = Intent(this,coldDrinks::class.java)
            startActivity(intent)
        }

        btnHotDrink.setOnClickListener{
            var intent = Intent(this,hotDrinks::class.java)
            startActivity(intent)
        }
        btnDulces.setOnClickListener{
            var intent = Intent(this,dulces::class.java)
            startActivity(intent)
        }
        btnSalties.setOnClickListener{
            var intent = Intent(this,salties::class.java)
            startActivity(intent)
        }
        btnCombos.setOnClickListener{
            var intent = Intent(this,combos::class.java)
            startActivity(intent)
        }
        btnPersonalized.setOnClickListener{
            var intent = Intent(this,personalized::class.java)
            startActivity(intent)
        }

    }
}
