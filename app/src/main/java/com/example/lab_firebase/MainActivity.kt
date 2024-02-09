package com.example.lab_firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    private val TAG: String = "Main Activity"
    var mainSignin : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainSignin = findViewById(R.id.main_emailBtn)
        // เป็นการดึงข้อมูลการ login จาก Firebase Authentication
        mAuth = FirebaseAuth.getInstance()
        //กรณีที5มีการ login ค้างไว้ จะสามารถเข้าหน้า result ได้เลย
        if (mAuth!!.currentUser != null) {
            Log.d(TAG, "Continue with: " + mAuth!!.currentUser!!.email)
            // เป็นการสั5งให้ทําการ start activity ส่วนของหน้า result
            startActivity(
                Intent(this@MainActivity,
                ResultActivity::class.java)
            )
            finish()
        }
        mainSignin?.setOnClickListener {
            startActivity(Intent(this@MainActivity,
                LoginActivity::class.java))
        }
    }
}
