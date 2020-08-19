package com.example.mvvmdemo.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.R
import com.example.mvvmdemo.viewmodel.MickyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mickyViewModel: MickyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    private fun initListeners() {
        //initializing the view model
        mickyViewModel = ViewModelProvider(this).get(MickyViewModel::class.java)
        mickyViewModel.init()
        btn_submit.setOnClickListener {
            mickyViewModel.saveUserData(edt_name.text.toString(), edt_age.text.toString())
        }

        //receives the response in view when the data has changed in model - notified via View model
        mickyViewModel.getSaveResponse().observe(this, Observer {
            Log.e("**Response Status***", "*$it")
            Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show()
        })
    }
}
