package org.wit.soulsbuildplanner.console.controllers

import mu.KotlinLogging
import org.wit.soulsbuildplanner.console.models.BuildModelMemStore
import org.wit.soulsbuildplanner.console.models.BuildModel
import org.wit.soulsbuildplanner.console.views.BuildView


class BuildController {

    val logger = KotlinLogging.logger {}
    val builds = BuildModelMemStore()
    val buildView = BuildView()

    init {
        logger.info {"Launching Souls Build Planner Console"}
        println("Souls Build Planner Kotlin App V1.0")
    }

    fun menu(): Int { return buildView.menu() }

    fun add(){
        var aBuildModel = BuildModel()

        if(buildView.addBuildModelData(aBuildModel))
            builds.create(aBuildModel)
        else
            logger.info("Build Not Added")
    }

    fun list(){
        buildView.listBuildModels(builds)
    }

    fun update(){
        buildView.listBuildModels(builds)
        var searchId = buildView.getId()
        var aBuildModel = search(searchId)

        if(aBuildModel != null){
            if(buildView.updateBuildModelData(aBuildModel)){
                builds.update(aBuildModel)
                buildView.showBuild(aBuildModel)
                logger.info("Build Updated : [ $aBuildModel ]")
            }
            else
                logger.info("Build Not Updated")
        }
    }

    fun search(){
        val aBuildModel = search(buildView.getId())!!
        buildView.showBuild(aBuildModel)

    }

    fun search(id: Long): BuildModel?{
        var foundBuild = builds.findOne(id)
        return foundBuild
    }

    fun dummyData() {
        builds.create(BuildModel(1, "Quality",25 ,35 ))
        builds.create(BuildModel(2, "Strength", 25, 40))
        builds.create(BuildModel(3, "Dexterity", 30, 40))
    }
}