package org.wit.soulsbuildplanner.console.views

//import org.wit.soulsbuildplanner.console.models.BuildModelMemStore
import org.wit.soulsbuildplanner.console.models.BuildJSONStore
import org.wit.soulsbuildplanner.console.models.BuildModel

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

    fun listBuildModels(buildModels: BuildJSONStore) {
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
        print("Enter Vigor : ")
        buildModel.vigor = readLine()!!.toInt()
        print("Enter Attunement")
        buildModel.attunement = readLine()!!.toInt()
        print("Enter Endurance : ")
        buildModel.endurance = readLine()!!.toInt()
        print("Enter Vitality")
        buildModel.vitality = readLine()!!.toInt()
        print("Enter Strength : ")
        buildModel.strength = readLine()!!.toInt()
        print("Enter Dexterity : ")
        buildModel.dexterity = readLine()!!.toInt()
        print("Enter Intelligence : ")
        buildModel.intelligence = readLine()!!.toInt()
        print("Enter Faith : ")
        buildModel.faith = readLine()!!.toInt()
        print("Enter Luck : ")
        buildModel.luck = readLine()!!.toInt()



        return buildModel.buildTitle.isNotEmpty() && buildModel.vigor != null && buildModel.attunement != null && buildModel.endurance != null && buildModel.vitality != null && buildModel.strength != null && buildModel.dexterity != null && buildModel.intelligence != null && buildModel.faith != null && buildModel.luck != null
    }


    fun updateBuildModelData(buildModel: BuildModel): Boolean {
        var tempBuildTitle: String?
        var tempVigor: Int?
        var tempAttunement: Int?
        var tempEndurance: Int?
        var tempVitality: Int?
        var tempStrength: Int?
        var tempDexterity: Int?
        var tempIntelligence: Int?
        var tempFaith: Int?
        var tempLuck: Int?


        if (buildModel != null) {
            print("Enter a new title for [ " + buildModel.buildTitle + " ] : ")
            tempBuildTitle = readLine()!!
            print("Enter a new Value for Vigor[ " + buildModel.vigor + " ] : ")
            tempVigor = readLine()!!.toInt()
            print("Enter a new Value for Attunement[ " + buildModel.attunement + " ] : ")
            tempAttunement = readLine()!!.toInt()
            print("Enter a new Value for Endurance[ " + buildModel.endurance + " ] : ")
            tempEndurance = readLine()!!.toInt()
            print("Enter a new value for Vitality[ " + buildModel.vitality + " ] : ")
            tempVitality = readLine()!!.toInt()
            print("Enter a new Value for Strength[ " + buildModel.strength + " ] : ")
            tempStrength = readLine()!!.toInt()
            print("Enter a new Value for Dexterity[ " + buildModel.dexterity + " ] : ")
            tempDexterity = readLine()!!.toInt()
            print("Enter a new Value for Intelligence[ " + buildModel.intelligence + " ] : ")
            tempIntelligence = readLine()!!.toInt()
            print("Enter a new value for Faith[ " + buildModel.faith + " ] : ")
            tempFaith = readLine()!!.toInt()
            print("Enter a new Value for Luck[ " + buildModel.luck + " ] : ")
            tempLuck = readLine()!!.toInt()


            if (!tempBuildTitle.isNullOrEmpty() && tempVigor != null && tempAttunement != null && tempEndurance != null && tempVitality != null && tempStrength != null && tempDexterity != null && tempIntelligence != null && tempFaith != null && tempLuck != null) {
                buildModel.buildTitle = tempBuildTitle
                buildModel.vigor = tempVigor
                buildModel.attunement = tempAttunement
                buildModel.endurance = tempEndurance
                buildModel.vitality = tempVitality
                buildModel.strength = tempStrength
                buildModel.dexterity = tempDexterity
                buildModel.intelligence = tempIntelligence
                buildModel.faith = tempFaith
                buildModel.luck = tempLuck
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
