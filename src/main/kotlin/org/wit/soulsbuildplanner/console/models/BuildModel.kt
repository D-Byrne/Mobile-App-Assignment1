package org.wit.soulsbuildplanner.console.models

data class BuildModel (var id: Long = 0,
                       var buildTitle: String = "",
                       var vigor: Int = 0,
                       var attunement: Int = 0,
                       var endurance: Int = 0,
                       var vitality: Int = 0,
                       var strength: Int = 0,
                       var dexterity: Int = 0,
                       var intelligence: Int = 0,
                       var faith: Int = 0,
                       var luck: Int = 0)
