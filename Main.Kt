MainActivity.kt

package com.example.formulario

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.formulario.ui.theme.FormularioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.layout)
        val EditarNombre: EditText= findViewById(R.id.Nombre)
        val EditarApPat: EditText= findViewById(R.id.ApPat)
        val EditarApMat: EditText= findViewById(R.id.ApMat)
        val EditarCorreo: EditText= findViewById(R.id.Correo)
        val EditarNum: EditText= findViewById(R.id.NumTel)

        val MostImagenValido = findViewById<ImageView>(R.id.DatValidosImagen)
        val MostrarImagenInv = findViewById<ImageView>(R.id.DatInvalImagen)

        val EnviarDatos: Button= findViewById(R.id.BotEnviar)

        EnviarDatos.setOnClickListener {
            val nom= EditarNombre.text.toString()
            val pat= EditarApPat.text.toString()
            val mat= EditarApMat.text.toString()
            val mail= EditarCorreo.text.toString()
            val fono = EditarNum.text.toString()

            if (validDatos(nom,pat, mat, mail, fono)) {
                Toast.makeText(this, "Datos válidos", Toast.LENGTH_SHORT).show()
                MostImagenValido.visibility= View.VISIBLE
                MostrarImagenInv.visibility= View.GONE
            } else {
                Toast.makeText(this, "Datos inválidos", Toast.LENGTH_SHORT).show()
                MostrarImagenInv.visibility= View.VISIBLE
                MostImagenValido.visibility= View.GONE
            }
            }
    }
}

fun validDatos(nom: String, pat: String, mat: String, mail: String, fono: String): Boolean {
    return validNombre(nom) && validPat(pat) && validMat(mat) && validMail(mail) && validTel(fono)
}

fun validNombre(nom: String): Boolean {
    return nom.isNotEmpty()
}

fun validPat(pat: String): Boolean {
    return pat.isNotEmpty()
}

fun validMat(mat: String): Boolean {
    return mat.isNotEmpty()
}

fun validMail(mail: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()
}

fun validTel(fono: String): Boolean {
    return android.util.Patterns.PHONE.matcher(fono).matches()
}


Layout.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:ignore="ExtraText">

    <TextView
        android:id="@+id/encabezado"
        android:layout_width="300dp"
        android:layout_height="60dp"
        android:text="@string/formulario"
        android:textColor="@android:color/black"
        android:textSize="40sp"
        android:fontFamily="arial"
        android:gravity="center"
        android:background="@color/purple_200"/>

    <EditText
        android:id="@+id/Nombre"
        android:layout_width="300dp"
        android:layout_height="80dp"
        android:layout_marginLeft="-270dp"
        android:layout_marginTop="100dp"
        android:hint="@string/HintNombre"
        android:inputType="textPersonName" />

    <EditText
        android:id="@+id/ApPat"
        android:layout_width="150dp"
        android:layout_height="80dp"
        android:layout_marginLeft="-300dp"
        android:layout_marginTop="200dp"
        android:hint="@string/HintApPat"
        android:inputType="textPersonName" />

    <EditText
        android:id="@+id/ApMat"
        android:layout_width="150dp"
        android:layout_height="80dp"
        android:layout_marginLeft="30dp"
        android:layout_marginTop="200dp"
        android:hint="@string/HintApMat"
        android:inputType="textPersonName" />

    <EditText
        android:id="@+id/Correo"
        android:layout_width="300dp"
        android:layout_height="80dp"
        android:layout_marginLeft="-330dp"
        android:layout_marginTop="300dp"
        android:hint="@string/HintCorreo"
        android:inputType="textEmailAddress" />

    <EditText
        android:id="@+id/NumTel"
        android:layout_width="300dp"
        android:layout_height="80dp"
        android:layout_marginLeft="-300dp"
        android:layout_marginTop="400dp"
        android:hint="@string/HintTel"
        android:inputType="phone" />

    <Button
        android:id="@+id/BotEnviar"
        android:layout_width="200dp"
        android:layout_height="50dp"
        android:layout_marginBottom="30dp"
        android:layout_marginLeft="-220dp"
        android:layout_gravity="center|bottom"
        android:text="Enviar"
        android:textColor="@color/white"
        android:backgroundTint="@color/purple_200" />

    <ImageView
        android:id="@+id/DatValidosImagen"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/datosvalidimagen"
        android:layout_gravity="center"
        android:visibility="gone" />

    <ImageView
        android:id="@+id/DatInvalImagen"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/datosinvalidimagen"
        android:layout_gravity="center"
        android:visibility="gone" />

    <ImageView
        android:id="@+id/PerfilFoto"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:layout_alignParentTop="true"
        android:layout_alignParentEnd="true"
        android:layout_margin="16dp"
        android:src="@drawable/fotoperfil" />

</LinearLayout>

Strings.xml

<resources>
    <string name="app_name">Formulario</string>
    <string name="formulario">Formulario</string>
    <string name="HintNombre">Escribe tu nombre(s)</string>
    <string name="HintApPat">Apellido paterno</string>
    <string name="HintApMat">Apellido materno</string>
    <string name="HintCorreo">Escribe tu correo electrónico</string>
    <string name="HintTel">Ingresa tu número telefónico</string>
</resources>

