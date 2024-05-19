package pnj.uts.ti.yuusha_yuzka

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edtusername:EditText
    lateinit var edtpassword:EditText
    lateinit var buttonlogin:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        edtusername = findViewById(R.id.editTextemail)
        edtpassword = findViewById(R.id.editTextpassword)
        buttonlogin =  findViewById(R.id.buttonsubmit)


        buttonlogin.setOnClickListener {
            if (edtusername.text.toString().equals("yuushayuzka@gmail.com")&& edtpassword.text.toString().equals("409860")) {
                var data = getSharedPreferences("Profile", Context.MODE_PRIVATE)
                var edit = data.edit()
                edit.putString("email", "yuushayuzka@gmail.com")
                edit.putString("nim", "2207411022")
                edit.putString("nama", "Yuusha")
                edit.putString("kelas", "TI4A")
                edit.putBoolean("IsLogin", true)
                edit.commit()

                var pindah = Intent(applicationContext, HomeActivity::class.java)
                startActivity(pindah)
                finish()
            } else{
                Toast.makeText(applicationContext,"loginsalah",Toast.LENGTH_SHORT).show()
            }
        }

    }
}
