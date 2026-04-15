package com.example.learnandroid.src.utils

import androidx.navigation.NavController
import com.example.learnandroid.R

object Navigator {
    private var navController: NavController? = null

    fun setNavController(controller: NavController) {
        navController = controller
    }

    fun push(destinationId: Int) {
        navController?.navigate(destinationId)
    }

    fun pop() {
        navController?.popBackStack()
    }

    fun reset(destinationId: Int = R.id.FirstFragment) {
        val controller = navController ?: return

        controller.navigate(destinationId) {
            popUpTo(controller.graph.id) {
                inclusive = true
            }
        }
    }
}