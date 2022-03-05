package com.example.workbranch


import kotlinx.coroutines.*

suspend fun main() {
    CoroutineScope(Dispatchers.Default).launch {
        delay(2000)
        print("Hello ")
    }

    delay(1000)
    print("World ")
    Thread.sleep(2000)
}
