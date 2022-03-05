package com.example.workbranch

import kotlinx.coroutines.*

/////////////////////////////
//«I'm sleeping 0 ...
//I'm sleeping 1 ...
//I'm sleeping 2 ...
//main: I'm tired of waiting!
//I'm running finally
//main: Now I can quit.»
//////////////////////////////

fun main(args: Array<String>) = runBlocking{
    val job = launch {
        try {
            repeat(3) { i ->
                println("I'm sleeping $i ...")
            }
            println("${Thread.currentThread().name}: I'm tired of waiting!")
        } finally {
            println("I'm running finally")
        }
        println("${Thread.currentThread().name}: Now I can quit.")
    }

}
