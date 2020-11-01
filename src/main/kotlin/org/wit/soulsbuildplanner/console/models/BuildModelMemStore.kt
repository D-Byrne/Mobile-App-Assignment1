package org.wit.soulsbuildplanner.console.models

import mu.KotlinLogging
//import org.wit.soulsbuildplanner.console.main.buildModels

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long{
    return lastId++
}

class BuildModelMemStore : BuildModelStore {

    val buildmodels = ArrayList<BuildModel>()

    override fun findAll(): List<BuildModel>{
        return buildmodels
    }

    override fun findOne(id: Long) : BuildModel? {
        var foundBuildModel: BuildModel? = buildmodels.find { p -> p.id == id }
        return foundBuildModel
    }

    override fun create(buildModel: BuildModel){
        buildModel.id = getId()
        buildmodels.add(buildModel)
        logAll()
    }

    override fun update(buildModel: BuildModel){
        var foundBuildModel = findOne(buildModel.id!!)
        if(foundBuildModel != null){
            foundBuildModel.buildTitle = buildModel.buildTitle
            foundBuildModel.vitality = buildModel.vitality
            foundBuildModel.endurance = buildModel.endurance
        }
    }

    internal fun logAll() {
        buildmodels.forEach { logger.info("$it") }
    }
}