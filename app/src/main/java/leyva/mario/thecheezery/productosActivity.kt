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

class productosActivity : AppCompatActivity() {
    var coldDrinks = ArrayList<product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos2)

        cargarProductos()
        var adaptador = AdaptadorProductos(this, coldDrinks)
        listview.adapter = adaptador

    }

    fun cargarProductos(){
        coldDrinks.add(product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5))
        coldDrinks.add(product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6))
        coldDrinks.add(product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-tocoarse ground coffee in room temperature water for 12 hours or longer.", 3))
        coldDrinks.add(product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4))
        coldDrinks.add(product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7))
        coldDrinks.add(product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7))

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
