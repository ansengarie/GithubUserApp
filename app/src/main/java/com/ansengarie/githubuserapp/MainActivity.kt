package com.ansengarie.githubuserapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ansengarie.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<User>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvUsers = findViewById(R.id.rv_github_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<User>
        get() {
            val dataAvatar = resources.obtainTypedArray(R.array.data_github_avatar)
            val dataName = resources.getStringArray(R.array.data_github_name)
            val dataUsername = resources.getStringArray(R.array.data_github_username)
            val dataFollowers = resources.getStringArray(R.array.data_github_follower)
            val dataFollowing = resources.getStringArray(R.array.data_github_following)
            val dataCompany = resources.getStringArray(R.array.data_github_company)
            val dataLocation = resources.getStringArray(R.array.data_github_location)
            val dataRepository = resources.getStringArray(R.array.data_github_repository)

            val listUser = ArrayList<User>()
            for (i in dataName.indices) {
                val user = User(dataAvatar.getResourceId(i, -1), dataName[i], dataUsername[i], dataFollowers[i], dataFollowing[i], dataCompany[i], dataLocation[i], dataRepository[i])
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList() {
        if(applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUsers.layoutManager = GridLayoutManager(this, 2)
        }else{
            rvUsers.layoutManager = LinearLayoutManager(this)
        }
        val listUserAdapter = ListUserAdapter(list)
        rvUsers.adapter = listUserAdapter
    }
}