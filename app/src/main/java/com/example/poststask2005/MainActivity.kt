package com.example.poststask2005

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poststask2005.adapter.Adapter
import com.example.poststask2005.databinding.ActivityMainBinding
import com.example.poststask2005.model.Posts
import com.example.poststask2005.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        setContentView(binding.root)
        getPosts()
    }

    fun getPosts() {
        val call: Call<List<Posts>>? =
            RetrofitClient.getInstances()?.getMyApi()?.getPosts()
        call?.enqueue(object : Callback<List<Posts>> {
            override fun onResponse(
                call: Call<List<Posts>>,
                response: Response<List<Posts>>
            ) {
                val list: List<Posts> = response.body() as List<Posts>
                binding.recyclerView.adapter = Adapter(list)
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }

        }
        )
    }

}
