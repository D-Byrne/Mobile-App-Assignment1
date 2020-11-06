package org.wit.soulsbuildplanner.console.views

import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.geometry.Orientation
import javafx.scene.control.TableView
import javafx.scene.layout.GridPane
import org.wit.soulsbuildplanner.console.controllers.UIController
import org.wit.soulsbuildplanner.console.models.BuildModel
import tornadofx.*


class UIUpdateMenu : View("Update Builds") {
    val model = ViewModel()
    val uiController: UIController by inject()
    val tableContent = uiController.builds.findAll()
    val data = tableContent.observable()

    val _updateId = model.bind{ SimpleStringProperty() }

    val _buildTitle = model.bind { SimpleStringProperty() }
    val _vigor = model.bind { SimpleStringProperty() }
    val _attunement = model.bind { SimpleStringProperty() }
    val _endurance = model.bind { SimpleStringProperty() }
    val _vitality = model.bind { SimpleStringProperty() }
    val _strength = model.bind { SimpleStringProperty() }
    val _dexterity = model.bind { SimpleStringProperty() }
    val _intelligence = model.bind{ SimpleStringProperty() }
    val _faith = model.bind { SimpleStringProperty() }
    val _luck = model.bind  { SimpleStringProperty() }

    override val root = vbox {
        setPrefSize(921.0, 960.0)
        tableview(data) {
            readonlyColumn("ID", BuildModel::id)
            readonlyColumn("TITLE", BuildModel::buildTitle)
            readonlyColumn("Vigor", BuildModel::vigor)
            readonlyColumn("Attunement", BuildModel::attunement)
            readonlyColumn("Endurance", BuildModel::endurance)
            readonlyColumn("Vitality", BuildModel::vitality)
            readonlyColumn("Strength", BuildModel::strength)
            readonlyColumn("Dexterity", BuildModel::dexterity)
            readonlyColumn("Intelligence", BuildModel::intelligence)
            readonlyColumn("Faith", BuildModel::faith)
            readonlyColumn("Luck", BuildModel::luck)
        }
        form{
            fieldset(labelPosition = Orientation.VERTICAL){
                field("Id"){
                    textfield(_updateId).required()
                }
                field("Title") {
                    textfield(_buildTitle).required()
                }
                field("Vigor") {
                    textfield(_vigor).required()
                }
                field("Attunement") {
                    textfield(_attunement).required()
                }
                field("Endurance") {
                    textfield(_endurance).required()
                }
                field("Vitality") {
                    textfield(_vitality).required()
                }
                field("Strength") {
                    textfield(_strength).required()
                }
                field("Dexterity") {
                    textfield(_dexterity).required()
                }
                field("Intelligence") {
                    textfield(_intelligence).required()
                }
                field("Faith") {
                    textfield(_faith).required()
                }
                field("Luck") {
                    textfield(_luck).required()
                }
                button("Update"){
                    enableWhen(model.valid)
                    isDefaultButton = true
                    useMaxWidth = true
                    action {
                        uiController.update(_updateId.value.toLong(),_buildTitle.value, _vigor.value, _attunement.value, _endurance.value, _vitality.value, _strength.value, _dexterity.value, _intelligence.value, _faith.value, _luck.value  )
                    }
                }
//                button("Close") {
//                    useMaxWidth = true
//                    action {
//                        runAsyncWithProgress {
//                            uiController.closeUpdate()
//                        }
//                    }
//                }
            }
        }
    }

//    override fun onDock(){
//        _updateId.value = ""
//        _buildTitle.value = ""
//        _vigor.value = ""
//        _attunement.value = ""
//        _endurance.value = ""
//        _vitality.value = ""
//        _strength.value = ""
//        _dexterity.value = ""
//        _intelligence.value = ""
//        _faith.value = ""
//        _luck.value = ""
//    }


}