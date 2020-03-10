package leyva.mario.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.combo_view.view.*
import kotlinx.android.synthetic.main.paquetes.*

class paquetes : AppCompatActivity() {

    var combos = ArrayList<combo>()
    var adaptador: AdaptadorCombos? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paquetes)
        cargarCombos()
        adaptador = AdaptadorCombos(this,combos)
        gridview.adapter = adaptador


    }
    fun cargarCombos(){
        combos.add(combo("Coffe n cake",15,R.drawable.circulo))
        combos.add(combo("Coffe n cake",15,R.drawable.circulo))
        combos.add(combo("Coffe n cake",15,R.drawable.circulo))
        combos.add(combo("Coffe n cake",15,R.drawable.circulo))
        combos.add(combo("Coffe n cake",15,R.drawable.circulo))
        combos.add(combo("Coffe n cake",15,R.drawable.circulo))
    }

    class AdaptadorCombos: BaseAdapter {

        var combos = ArrayList<combo>()
        var contexto: Context?=null

        constructor(contexto: Context, combos: ArrayList<combo>){
            this.contexto = contexto
            this.combos = combos
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var combo = combos[position]
            var inflater = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflater.inflate(R.layout.combo_view,null)

            vista.comboImage.setImageResource(combo.img)
            vista.comboNombre.setText(combo.name)
            vista.comboPrecio.setText(combo.precio.toString())

            return vista

        }

        override fun getItem(position: Int): Any {
            return combos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return combos.size
        }


    }
}
