package org.wit.soulsbuildplanner.console.views

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import tornadofx.*
import kotlin.reflect.KClass
import org.wit.soulsbuildplanner.console.controllers.UIController

class UIAddMenu : View("Add Build") {
    val model = ViewModel()
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
    val uiController: UIController by inject()

    override val root = form {
        setPrefSize(600.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
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
            button("Add") {
                enableWhen(model.valid)
                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        uiController.add(_buildTitle.value, _vigor.value, _attunement.value, _endurance.value, _vitality.value, _strength.value, _dexterity.value, _intelligence.value, _faith.value, _luck.value  )

                    }
                }
            }
            button("Close") {
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        uiController.closeAdd()
                    }
                }
            }
        }
    }

    override fun onDock() {
        _buildTitle.value = ""
        _vigor.value = ""
        _attunement.value = ""
        _endurance.value = ""
        _vitality.value = ""
        _strength.value = ""
        _dexterity.value = ""
        _intelligence.value = ""
        _faith.value = ""
        _luck.value = ""
        model.clearDecorators()
    }
}