package org.wit.soulsbuildplanner.console.views

import javafx.application.Platform
import javafx.geometry.Orientation
import org.wit.soulsbuildplanner.console.controllers.UIController
import tornadofx.*

class UIMenu : View("Souls Build Planner Main Menu") {

    val uiController: UIController by inject()

    override val root = form {
        setPrefSize(400.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            text("")
            button("Add Build") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        uiController.loadAddScreen()
                    }
                }
            }
            text("")
            button("List/Delete Builds") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        uiController.loadListScreen()
                    }
                }
            }
            text("")
            button("Exit") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        Platform.exit();
                        System.exit(0);
                    }
                }
            }
        }

    }


}