package mx.edu.tecmm.moviles.micalculadora08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var txtRes: TextView
    var operacion = ""
    var n1 = 0
    var n2 = 0
    var digitos = "";
    lateinit var txtValor: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtRes = findViewById(R.id.txtResult)
        txtValor = findViewById(R.id.txtvalor1)
    }

    fun presiono(v: View ){
        val vista= v as TextView
        //Log.e("Boton", "presiono ${vista.text}")

         operacion= when(vista.text){
            "+" -> vista.text.toString()
            "-" -> vista.text.toString()
            else -> operacion
        }

        if (vista.text == "C") {
            limpiar()
        }else if (vista.text == "+") {
            sumar(vista)
        }else if (vista.text == "-") {
            restar(vista)
        }else if (vista.text == "=") {
            n2 = digitos.toInt()
            if (operacion == "+")
                txtRes.text = (n1 + n2).toString()
            if (operacion == "-")
                txtRes.text = (n1 - n2).toString()
            txtValor.text = txtValor.text.toString() + digitos
            digitos=  digitos+ vista.text;
        }else{
            //for ()
            digitos = digitos+ vista.text
            txtRes.text = digitos
        }
    }

    fun limpiar(){
        n1 = 0
        n2 = 0
        digitos = ""
        operacion = ""
        txtRes.text = "0"
        txtValor.text = ""
    }
    fun sumar (v: TextView){
        //val vista= v as TextView
        n1 = digitos.toInt()
        txtValor.text = digitos + v.text
        digitos = ""
        txtRes.text = ""
    }

    fun restar (v: TextView){
        n1 = digitos.toInt()
        txtValor.text = digitos + v.text
        digitos = ""
        txtRes.text = ""
    }
}