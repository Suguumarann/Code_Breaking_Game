package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafx.scene.control.Alert.AlertType
import scalafxml.core.macros.sfxml
import scalafx.scene.control.{Alert, TextInputDialog}

@sfxml
class MainMenuController {

  def handlePlay(action: ActionEvent): Unit = {

    val dialog2 = new TextInputDialog("")

    dialog2.title = "BREAK THE CODES"
    dialog2.headerText = "Enter Your Name:"
    dialog2.contentText = "Player Name:"

    val result = dialog2.showAndWait()

    result match {
      case Some(name) if name.trim.nonEmpty =>
        MainApp.showGameEngine()
      //The player entered a non-empty name,can proceed with the game

      case _ =>
        val errorAlert = new Alert(AlertType.Error)
        errorAlert.title = "ERROR"
        errorAlert.headerText = "ACCESS DENIED!"
        errorAlert.contentText = "PLEASE ENTER A VALID NAME!"
        errorAlert.showAndWait()
      //Player canceled the dialog or entered an empty name
    }
  }

  def handleExit(action: ActionEvent): Unit = {
    System.exit(0)
  }

  def handleHowToPlay(action: ActionEvent): Unit = {
    MainApp.showUserGuide()
  }

  def handleScoreboard(action: ActionEvent): Unit = {
    MainApp.showScoreboard()
  }
}
