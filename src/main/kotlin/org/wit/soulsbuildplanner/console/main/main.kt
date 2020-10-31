package org.wit.soulsbuildplanner.console.main

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>){
    logger.info { "Launching Souls Build Planner"}
    println("Souls Build Planner App V1.0")

    var input: Int

    do{
        input = menu()
        when(input){
            1 -> println("You Chose Create Build")
            2 -> println("You Chose Edit Build")
            3 -> println("You Chose List All Builds")
           -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while(input != -1)
    logger.info{ "Shutting Down Souls Build Planner" }
}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("Main Menu")
    println(" 1. Create Build")
    println(" 2. Edit Build")
    println(" 3. List all Builds")
    println("-1. Exit")
    println()
    print("Enter an integer : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9

    return option
}