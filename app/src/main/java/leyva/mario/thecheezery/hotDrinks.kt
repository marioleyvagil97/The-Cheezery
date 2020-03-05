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

class hotDrinks : AppCompatActivity() {
    var hotDrinks = ArrayList<product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_drinks)

        cargarproductos()

        var adaptador = AdaptadorProductos(this, hotDrinks)
        listview.adapter = adaptador

    }

    fun cargarproductos(){
        hotDrinks.add(product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6))
        hotDrinks.add(product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5))
        hotDrinks.add(product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4))
        hotDrinks.add(product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6))
        hotDrinks.add(product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7))
        hotDrinks.add(product("American coffee", R.drawable.americano, "Espresso with hot water", 2))
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
