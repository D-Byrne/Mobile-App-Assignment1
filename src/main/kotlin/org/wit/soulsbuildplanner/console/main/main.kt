package org.wit.soulsbuildplanner.console.main

import mu.KotlinLogging
import org.wit.soulsbuildplanner.console.models.BuildModel

private val logger = KotlinLogging.logger {}

//var buildModel = BuildModel()

val buildModels = ArrayList<BuildModel>()

fun main(args: Array<String>){
    logger.info { "Launching Souls Build Planner"}
    println("Souls Build Planner App V1.0")

    var input: Int

    do{
        input = menu()
        when(input){
            1 -> createBuild()
            2 -> updateBuild()
            3 -> listAllBuilds()
            4 -> searchBuildModel()
            -99 -> dummyData()
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
    println(" 2. Update Build")
    println(" 3. List all Builds")
    println(" 4. Search Builds")
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

fun createBuild(){
    var aBuildModel = BuildModel()
    println("Add Build")
    println()
    print("Enter Build Title : ")
    aBuildModel.buildTitle = readLine()!!
    print("Enter Vitality : ")
    aBuildModel.vitality = readLine()!!.toInt()
    print("Enter Endurance : ")
    aBuildModel.endurance = readLine()!!.toInt()

    if (aBuildModel.buildTitle.isNotEmpty() && aBuildModel.vitality != null && aBuildModel.endurance != null ){
        aBuildModel.id = buildModels.size.toLong()
        buildModels.add(aBuildModel.copy())
        logger.info("Build Added : [ $aBuildModel ]")
    }
    else
        logger.info("Buid Not Added")
}

fun updateBuild(){
    println("Update Build")
    println()
    listAllBuilds()
    var  searchId = getId()
    val aBuildModel = search(searchId)

    if(aBuildModel != null){
        print("Enter a new title for [ " + aBuildModel.buildTitle + " ] : ")
        aBuildModel.buildTitle = readLine()!!
        print("Enter a new value for Vitality[ " + aBuildModel.vitality + " ] : ")
        aBuildModel.vitality = readLine()!!.toInt()
        print("Enter a new value for Endurance[ " + aBuildModel.endurance + " ] : ")
        aBuildModel.endurance = readLine()!!.toInt()
        println(
            "You updated [ " + aBuildModel.buildTitle + " ] for build title " +
                    "and [ " + aBuildModel.vitality + " ] for vitality " +
                    "and [ " + aBuildModel.endurance + " ] for endurance"
        )
    }
    else
        println("Build Not Updated...")
}

fun listAllBuilds(){
    println("List All Builds")
    println()
    buildModels.forEach { logger.info("${it}") }
    println()
}

fun searchBuildModel(){
    var searchId = getId()
    val aBuildModel = search(searchId)

    if(aBuildModel != null)
        println("Build Details [ $aBuildModel ]")
    else
        println("Build Not Found...")
}

fun getId() : Long {
    var strId : String?
    var searchId : Long
    print("Enter id to Search/Update : ")
    strId = readLine()!!
    searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
        strId.toLong()
    else
        -9
    return searchId
}

fun search(id: Long) : BuildModel? {
    var foundBuildModel: BuildModel? = buildModels.find { p -> p.id == id }
    return foundBuildModel
}

fun dummyData() {
    buildModels.add(BuildModel(1, "Quality",25 ,35 ))
    buildModels.add(BuildModel(2, "Strength", 25, 40))
    buildModels.add(BuildModel(3, "Dexterity", 30, 40))
}