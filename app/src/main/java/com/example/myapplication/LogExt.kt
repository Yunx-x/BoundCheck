package com.example.myapplication

import android.util.Log


fun Any.log(log: String) {
    Log.e("---------", log)
}


fun main() {
    println("%.2f".format(0.7 / 5.0))
}