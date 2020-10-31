package org.wit.soulsbuildplanner.console.views

import mu.KotlinLogging
import org.wit.soulsbuildplanner.console.models.BuildModelMemStore
import org.wit.soulsbuildplanner.console.models.BuildModel
import org.wit.soulsbuildplanner.console.views.BuildView

class BuildView {

    fun menu(): Int {
        var option: Int
        var input: String?

        println("Main Menu")
        println(" 1. Add Build")
        println(" 2. Update Build")
        println(" 3. List All Builds")
        println(" 4. Search Builds")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listBuildModels(buildModels: BuildModelMemStore) {
        println("List All Builds")
        println()
        buildModels.logAll()
        println()
    }

    fun showBuild(buildModel: BuildModel) {
        if (buildModel != null)
            println("Build Details [ $buildModel ]")
        else
            println("Build Not Found...")
    }

    fun addBuildModelData(buildModel: BuildModel): Boolean {
        println()
        print("Enter a Build Tile : ")
        buildModel.buildTitle = readLine()!!
        print("Enter Vitality : ")
        buildModel.vitality = readLine()!!.toInt()
        print("Enter Endurance : ")
        buildModel.endurance = readLine()!!.toInt()

        return buildModel.buildTitle.isNotEmpty() && buildModel.vitality != null && buildModel.endurance != null
    }


    fun updateBuildModelData(buildModel: BuildModel): Boolean {
        var tempBuildTitle: String?
        var tempVitality: Int?
        var tempEndurance: Int?

        if (buildModel != null) {
            print("Enter a new title for [ " + buildModel.buildTitle + " ] : ")
            tempBuildTitle = readLine()!!
            print("Enter a new value for Vitality[ " + buildModel.vitality + " ] : ")
            tempVitality = readLine()!!.toInt()
            print("Enter a new value for Endurance[ " + buildModel.endurance + " ] : ")
            tempEndurance = readLine()!!.toInt()


            if (!tempBuildTitle.isNullOrEmpty() && tempVitality != null && tempEndurance != null) {
                buildModel.buildTitle = tempBuildTitle
                buildModel.vitality = tempVitality
                buildModel.endurance = tempEndurance
                return true
            }
        }
        return false
    }

    fun getId(): Long {
        var strId: String?
        var searchId: Long
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}
