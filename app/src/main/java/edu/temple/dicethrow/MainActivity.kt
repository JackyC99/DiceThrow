package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    val ViewModel: ViewModel by lazy(){
        ViewModelProvider(this)[ViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) == null)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, DieFragment())
                .commit()

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {

        }
    }

}