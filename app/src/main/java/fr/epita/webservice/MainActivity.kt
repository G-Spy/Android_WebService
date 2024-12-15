package fr.epita.webservice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

        val service = retrofit.create(WSInterface::class.java)

        val callback : Callback<List<ToDoModel>> = object : Callback<List<ToDoModel>> {
            override fun onResponse(
                call: Call<List<ToDoModel>>,
                response: Response<List<ToDoModel>>
            ) {
                TODO("Not yet implemented")
                val data : List<ToDoModel> = response.body()!!
                
            }

            override fun onFailure(call: Call<List<ToDoModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        }

        service.getAllTodos().enqueue(callback)

    }

}