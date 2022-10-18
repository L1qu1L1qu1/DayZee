package com.example.dayzee.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiHelper {
    fun createApiHelper():BookApi{
        var retrofit = Retrofit
            .Builder()
            .baseUrl("https://spring-boot-mysql-server-part0.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var bookApi:BookApi=retrofit.create(BookApi::class.java)
        return  bookApi
    }
}
fun main(){
   var cat:Animal = Cat()
   var dog:Animal = Dog()
    dog.voice()
    cat.voice()

    var carts:Cart = Carts()
    carts.ABC()
    carts.ABCDE()

    var nez: NeZnauChto = NeZnauChtooo()
    nez.sp()
}
interface Animal{
    fun voice()
}
class Cat():Animal{
    override fun voice() {
        println("Catsss")
    }
}
class Dog():Animal{
    override fun voice() {
      println("Dogsss")
    }
}

interface Cart{
    fun ABC(){
        println("qwerty")
    }
    fun ABCDE()
}
class Carts():Cart{
    override fun ABCDE() {
        println("override fun ABCDE")
    }
}
interface NeZnauChto{
    var speed: Int
    var length: Int
    fun sp()
}
class NeZnauChtooo(override var length: Int = 1000, override var speed: Int = 250):NeZnauChto{
    override fun sp(){
        println("Машина проезжает $length-й метр со скоростью $speed км/ч")
    }
}


