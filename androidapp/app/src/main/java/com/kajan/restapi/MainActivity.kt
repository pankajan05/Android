package com.kajan.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.kittinunf.result.Result
import com.github.kittinunf.fuel.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            val httpAsync = "https://jsonplaceholder.typicode.com/posts"
                .httpGet()
                .responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val ex = result.getException()
                            println(ex)
                        }
                        is Result.Success -> {
                            val data = result.get()
                            println(data)
                            
                        }
                    }
                }

            httpAsync.join()
        }
    }
}
