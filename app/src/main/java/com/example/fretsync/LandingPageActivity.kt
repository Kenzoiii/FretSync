package com.example.fretsync

import Slide
import SlideAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class LandingPageActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var dotsIndicator: WormDotsIndicator
    private lateinit var btnGetStarted: Button
    private lateinit var slideAdapter: SlideAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        viewPager = findViewById(R.id.viewPager)
        dotsIndicator = findViewById(R.id.dotsIndicator)
        btnGetStarted = findViewById(R.id.btnGetStarted)

        // List of slides
        val slides = listOf(
            Slide(R.drawable.image_placeholder, "Explore Guitars", "Discover various guitar models and their unique sounds."),
            Slide(R.drawable.image_placeholder, "History of Guitars", "Learn how guitars evolved over time."),
            Slide(R.drawable.image_placeholder, "Join the Guitar Community", "Connect with fellow guitar enthusiasts worldwide.")
        )

        // Set up ViewPager Adapter
        slideAdapter = SlideAdapter(slides)
        viewPager.adapter = slideAdapter
        dotsIndicator.attachTo(viewPager)

        // Detect last slide & show "Get Started" button
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == slides.size - 1) {
                    btnGetStarted.visibility = View.VISIBLE
                } else {
                    btnGetStarted.visibility = View.GONE
                }
            }
        })

        // Button Click -> Navigate to Main Activity
        btnGetStarted.setOnClickListener {
            startActivity(Intent(this, MainScreenActivity::class.java))
            finish() // Close Landing Page so user doesn't go back to it
        }
    }
}
