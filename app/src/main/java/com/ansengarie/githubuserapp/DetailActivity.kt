package com.ansengarie.githubuserapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ansengarie.githubuserapp.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailUser = intent.getParcelableExtra<User>(EXTRA_DATA)
        with(binding) {
            Glide.with(
            this@DetailActivity)
                .load(detailUser?.avatar)
                .into(detailAvatar)
            title = detailUser?.name
            detailName.text = detailUser?.name
            detailUsername.text = detailUser?.username
            detailFollowing.text = detailUser?.following
            detailFollowers.text = detailUser?.follower
            detailCompany.text = detailUser?.company
            detailLocation.text = detailUser?.location
            detailRepository.text = detailUser?.repository
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}