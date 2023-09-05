package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml

@sfxml
class UserGuideController {

  def handleReturnHome(action: ActionEvent): Unit = {
    MainApp.showMainMenu()
  }
}