package org.wit.soulsbuildplanner.console.controllers

import mu.KotlinLogging
import org.wit.soulsbuildplanner.console.models.BuildJSONStore
import org.wit.soulsbuildplanner.console.models.BuildModel
import org.wit.soulsbuildplanner.console.views.UIAddMenu
import org.wit.soulsbuildplanner.console.views.UIListMenu
import org.wit.soulsbuildplanner.console.views.UIMenu
import tornadofx.*

class UIController : Controller() {

    val builds = BuildJSONStore()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Placemark TornadoFX UI App" }
    }
    fun add(_buildTitle : String, _vigor : String, _attunement : String, _endurance : String, _vitality : String, _strength : String, _dexterity : String, _intelligence : String, _faith : String, _luck : String){

        var aBuildModel = BuildModel(buildTitle = _buildTitle, vigor = _vigor.toInt(), attunement = _attunement.toInt(), endurance = _endurance.toInt(), vitality = _vitality.toInt(), strength = _strength.toInt(), dexterity = _dexterity.toInt(), intelligence = _intelligence.toInt(), faith = _faith.toInt(), luck = _luck.toInt()  )
        builds.create(aBuildModel)
        logger.info("Build Added")
    }

    fun delete(_delId : Long){
        var delId = _delId
        val toDelete = builds.findOne(delId)

        if(toDelete != null){
            builds.delete(toDelete)
            logger.info("Build Deleted")
        }else
            logger.info("Build Not Deleted")

    }

    fun loadListScreen() {
        runLater {
            find(UIMenu::class).replaceWith(UIListMenu::class, sizeToScene = true, centerOnScreen = true)
        }
        builds.logAll()
    }

    fun loadAddScreen() {
        runLater {
            find(UIMenu::class).replaceWith(UIAddMenu::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeAdd() {
        runLater {
            find(UIAddMenu::class).replaceWith(UIMenu::class, sizeToScene = true, centerOnScreen = true)
        }
    }
    fun closeList() {
        runLater {
            find(UIListMenu::class).replaceWith(UIMenu::class, sizeToScene = true, centerOnScreen = true)
        }
    }

}