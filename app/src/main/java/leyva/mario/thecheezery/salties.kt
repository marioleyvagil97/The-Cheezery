package leyva.mario.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_productos.*
import kotlinx.android.synthetic.main.producto_view.view.*

class salties : AppCompatActivity() {
    var salties = ArrayList<product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salties)

        cargarproductos()
        var adaptador = AdaptadorProductos(this, salties)
        listview.adapter = adaptador



    }
    fun cargarproductos(){

        salties.add(product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6))

        salties.add(product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5))

        salties.add(product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread served warmed by grilling.", 4))

        salties.add(product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6))

        salties.add(product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.", 7))
    }
    private class AdaptadorProductos: BaseAdapter {
        var productos = ArrayList<product>()
        var contexto: Context? = null

        constructor(contexto: Context, productos: ArrayList<product>){
            this.contexto = contexto
            this.productos = productos
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            vista.producto_img.setImageResource(prod.image)
            vista.producto_nombre.setText(prod.name)
            vista.producto_desc.setText(prod.description)
            vista.producto_precio.setText("$${prod.price}")

            return vista
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return productos.size
        }

    }


}
