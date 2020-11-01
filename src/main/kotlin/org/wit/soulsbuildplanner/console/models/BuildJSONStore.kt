package org.wit.soulsbuildplanner.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

import org.wit.soulsbuildplanner.console.helpers.*
import java.util.*

val JSON_FILE = "builds.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<BuildModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class BuildJSONStore: BuildModelStore {

    var builds = mutableListOf<BuildModel>()

    init {
        if (exists(JSON_FILE)){
            deserialize()
        }
    }

    override fun findAll(): MutableList<BuildModel>{
        return builds
    }

    override fun findOne(id: Long) : BuildModel? {
        var foundBuild: BuildModel? = builds.find { p -> p.id == id }
        return foundBuild
    }

    override fun create(buildModel: BuildModel){
        buildModel.id = generateRandomId()
        builds.add(buildModel)
        serialize()
    }

    override fun update(buildModel: BuildModel){
        var foundBuild = findOne(buildModel.id!!)
        if(foundBuild != null){
            foundBuild.buildTitle = buildModel.buildTitle
            foundBuild.vigor = buildModel.vigor
            foundBuild.attunement = buildModel.attunement
            foundBuild.endurance = buildModel.endurance
            foundBuild.vitality = buildModel.vitality
            foundBuild.strength = buildModel.strength
            foundBuild.dexterity = buildModel.dexterity
            foundBuild.intelligence = buildModel.intelligence
            foundBuild.faith = buildModel.faith
            foundBuild.luck = buildModel.luck
        }
        serialize()
    }

    internal fun logAll(){
        builds.forEach{ logger.info("${it}") }
    }

    private fun serialize(){
        val jsonString = gsonBuilder.toJson(builds, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize(){
        val jsonString = read(JSON_FILE)
        builds = Gson().fromJson(jsonString, listType)
    }

}