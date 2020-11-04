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

class UIListMenu : View("List Builds") {
    val model = ViewModel()

    val uiController: UIController by inject()
    val tableContent = uiController.builds.findAll()
    val data = tableContent.observable()

    val _delId = model.bind { SimpleStringProperty() }


    override val root = vbox {
        setPrefSize(921.0, 525.0)
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
        button("Close") {
            useMaxWidth = true
            action {
                runAsyncWithProgress {
                    uiController.closeList()
                }
            }
        }
        form {
            fieldset(labelPosition = Orientation.VERTICAL) {
                field("Delete") {
                    textfield(_delId).required()
                }
                button("Delete") {
                    enableWhen(model.valid)
                    isDefaultButton = true
                    useMaxWidth = true
                     action {
                         uiController.delete(_delId.value.toLong())
                         uiController.closeList()
                         uiController.loadListScreen()
                     }
                }
            }
        }
    }

    override fun onDock(){
        _delId.value = ""
        model.clearDecorators()
    }


}