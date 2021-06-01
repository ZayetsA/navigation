package com.onix.internship.navigation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavArgument
import androidx.navigation.fragment.NavHostFragment
import com.onix.internship.navigation.R
import com.onix.internship.navigation.ui.score.ScoreModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainNavHostFragment) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)
        val argument = NavArgument.Builder().setDefaultValue(ScoreModel()).build()
        graph.addArgument("model", argument)
        navHostFragment.navController.graph = graph
    }
}