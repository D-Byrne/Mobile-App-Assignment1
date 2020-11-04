package org.wit.soulsbuildplanner.console.models

interface BuildModelStore {
    fun findAll(): List<BuildModel>
    fun findOne(id: Long): BuildModel?
    fun create(buildModel: BuildModel)
    fun update(buildModel: BuildModel)
    fun delete(buildModel: BuildModel)
}