package com.example.workbranch

import kotlinx.coroutines.*

suspend fun main() {
    async()
    Thread.sleep(5000)
    println()
    sync()
}
suspend fun first() : Int {
    delay(1000)
    return 4
}
suspend fun second() : Int {
    delay(2000)
    return 5
}
suspend fun async(){
    var res1 = 0
    var res2 = 0
    println("async")
    val startTime = System.currentTimeMillis()
    withContext(Dispatchers.Default){
        joinAll(
        launch {res1 = first() },
        launch {res2 = second() }
        )
    }
    val totalTime = System.currentTimeMillis() - startTime

    println(totalTime)



}
suspend fun sync(){
    println("sync")
    val startTime = System.currentTimeMillis()
    first()
    second()
    val totalTime = System.currentTimeMillis() - startTime
    println(totalTime)
}
//async
//2400

//sync
//3020
//такие результаты получились из-за того что в асинхронном режиме работы следующая
// функция начала работать до завершения предыдущей
