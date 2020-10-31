package org.wit.soulsbuildplanner.console.main

import mu.KotlinLogging
import org.wit.soulsbuildplanner.console.models.BuildModel
import org.wit.soulsbuildplanner.console.models.BuildModelMemStore
import org.wit.soulsbuildplanner.console.views.BuildView

private val logger = KotlinLogging.logger {}

//var buildModel = BuildModel()

//val buildModels = ArrayList<BuildModel>()

val buildModels = BuildModelMemStore()
val buildView = BuildView()

fun main(args: Array<String>){
    logger.info { "Launching Souls Build Planner"}
    println("Souls Build Planner App V1.0")

    var input: Int

    do{
        input = buildView.menu()
        when(input){
            1 -> addBuild()
            2 -> updateBuild()
            3 -> buildView.listBuildModels(buildModels)
            4 -> searchBuildModel()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while(input != -1)
    logger.info{ "Shutting Down Souls Build Planner" }
}

fun addBuild(){
    var aBuildModel = BuildModel()

    if(buildView.addBuildModelData(aBuildModel))
        buildModels.create(aBuildModel)
    else
        logger.info("Build Not Added...")
}

fun updateBuild(){
    buildView.listBuildModels(buildModels)
    var searchId = buildView.getId()
    val aBuildModel = search(searchId)

    if(aBuildModel != null){
        if(buildView.updateBuildModelData(aBuildModel)){
            buildModels.update(aBuildModel)
            buildView.showBuild(aBuildModel)
            logger.info("Build Updated : [ $aBuildModel ]")
        }
        else
            logger.info("Build Not updated...")
    }

}

fun searchBuildModel(){
    val aBuildModel = search(buildView.getId())!!
    buildView.showBuild(aBuildModel)
}

fun search(id: Long) : BuildModel? {
    var foundBuild = buildModels.findOne(id)
    return foundBuild
}

fun dummyData() {
    buildModels.create(BuildModel(1, "Quality",25 ,35 ))
    buildModels.create(BuildModel(2, "Strength", 25, 40))
    buildModels.create(BuildModel(3, "Dexterity", 30, 40))
}