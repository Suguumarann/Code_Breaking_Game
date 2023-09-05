package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafx.scene.control.Label
import scalafxml.core.macros.sfxml
import scalafx.stage.Stage

@sfxml
class FinalMessageController(private val winStatus: Label){
  var dialogStage: Stage  = null
  var winOrLose: Boolean = false

  def showEnd(winOrLose: Boolean): Unit = {
    if (winOrLose){
    }
    else{
      winStatus.text = "YOU LOST!"
    }
  }

  def handlePlayAgain(action: ActionEvent): Unit = {
    dialogStage.close()
    MainApp.showGameEngine()
  }

  def handleReturnHome(action: ActionEvent): Unit = {
    dialogStage.close()
    MainApp.showMainMenu()
  }
}