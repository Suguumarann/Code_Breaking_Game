package ch.makery.address

import scalafx.scene.Scene
import scalafx.application.JFXApp
import javafx.{scene => jfxs}
import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafxml.core.{FXMLLoader, NoDependencyResolver}
import scalafx.stage.{Modality, Stage}
import ch.makery.address.view.FinalMessageController
import scalafx.scene.image.Image

object MainApp extends JFXApp {
  val rootResource = getClass.getResource("view/RootLayout.fxml")
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  loader.load()
  val roots = loader.getRoot[jfxs.layout.BorderPane]

  stage = new PrimaryStage{
    title = "BREAK THE CODES"
    width = 620
    height = 700
    icons += new Image("file:src/main/resources/ch/makery/address/view/images/wheel.png")

    scene = new Scene{
      root = roots
    }
  }

  def showMainMenu(): Unit = {
    val resource = getClass.getResource("view/MainMenu.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showUserGuide(): Unit = {
    val resource = getClass.getResource("view/UserGuide.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showGameEngine(): Unit = {
    val resource = getClass.getResource("view/GameEngine.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showScoreboard(): Unit = {
    val resource = getClass.getResource("view/Scoreboard.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showFinalMessage(winOrLose: Boolean): Unit = {
    val resource = getClass.getResourceAsStream("view/FinalMessage.fxml")
    val loader = new FXMLLoader(null, NoDependencyResolver)
    loader.load(resource)
    val roots2 = loader.getRoot[jfxs.Parent]
    val control = loader.getController[FinalMessageController#Controller]

    val dialog = new Stage() {
      title = "BREAK THE CODES"
      icons += new Image("file:src/main/resources/ch/makery/address/view/images/wheel.png")
      initModality(Modality.APPLICATION_MODAL)
      initOwner(stage)
      scene = new Scene {
        root = roots2
      }
    }

    control.dialogStage = dialog
    control.showEnd(winOrLose)
    dialog.showAndWait()
  }

  showMainMenu()
}