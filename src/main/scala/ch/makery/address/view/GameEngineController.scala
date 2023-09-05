package ch.makery.address.view

import ch.makery.address.MainApp
import ch.makery.address.model.Final
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml
import scalafx.scene.shape.Circle
import scala.collection.mutable.ListBuffer
import scalafx.scene.paint.Color
import scalafx.scene.layout.GridPane

@sfxml
class GameEngineController(
                          private val answer1: Circle, private val answer2: Circle, private val answer3: Circle, private val answer4: Circle,
                          private var guess1_1: Circle, private var guess1_2: Circle, private var guess1_3: Circle, private var guess1_4: Circle,
                          private var guess2_1: Circle, private var guess2_2: Circle, private var guess2_3: Circle, private var guess2_4: Circle,
                          private var guess3_1: Circle, private var guess3_2: Circle, private var guess3_3: Circle, private var guess3_4: Circle,
                          private var guess4_1: Circle, private var guess4_2: Circle, private var guess4_3: Circle, private var guess4_4: Circle,
                          private var guess5_1: Circle, private var guess5_2: Circle, private var guess5_3: Circle, private var guess5_4: Circle,
                          private var guess6_1: Circle, private var guess6_2: Circle, private var guess6_3: Circle, private var guess6_4: Circle,
                          private var guess7_1: Circle, private var guess7_2: Circle, private var guess7_3: Circle, private var guess7_4: Circle,
                          private var guess8_1: Circle, private var guess8_2: Circle, private var guess8_3: Circle, private var guess8_4: Circle,
                          private var guess9_1: Circle, private var guess9_2: Circle, private var guess9_3: Circle, private var guess9_4: Circle,
                          private var guess10_1: Circle, private var guess10_2: Circle, private var guess10_3: Circle, private var guess10_4: Circle,
                          private var feedback1_1: Circle, private var feedback1_2: Circle, private var feedback1_3: Circle, private var feedback1_4: Circle,
                          private var feedback2_1: Circle, private var feedback2_2: Circle, private var feedback2_3: Circle, private var feedback2_4: Circle,
                          private var feedback3_1: Circle, private var feedback3_2: Circle, private var feedback3_3: Circle, private var feedback3_4: Circle,
                          private var feedback4_1: Circle, private var feedback4_2: Circle, private var feedback4_3: Circle, private var feedback4_4: Circle,
                          private var feedback5_1: Circle, private var feedback5_2: Circle, private var feedback5_3: Circle, private var feedback5_4: Circle,
                          private var feedback6_1: Circle, private var feedback6_2: Circle, private var feedback6_3: Circle, private var feedback6_4: Circle,
                          private var feedback7_1: Circle, private var feedback7_2: Circle, private var feedback7_3: Circle, private var feedback7_4: Circle,
                          private var feedback8_1: Circle, private var feedback8_2: Circle, private var feedback8_3: Circle, private var feedback8_4: Circle,
                          private var feedback9_1: Circle, private var feedback9_2: Circle, private var feedback9_3: Circle, private var feedback9_4: Circle,
                          private var feedback10_1: Circle, private var feedback10_2: Circle, private var feedback10_3: Circle, private var feedback10_4: Circle,
                          private var gridPane1: GridPane, private var gridPane2: GridPane, private var gridPane3: GridPane, private var gridPane4: GridPane, private var gridPane5: GridPane,
                          private var gridPane6: GridPane, private var gridPane7: GridPane, private var gridPane8: GridPane, private var gridPane9: GridPane, private var gridPane10: GridPane,
                        ) {

  var answerList = ListBuffer(answer1, answer2, answer3, answer4)
  var guess1 = ListBuffer(guess1_1, guess1_2, guess1_3, guess1_4)
  var guess2 = ListBuffer(guess2_1, guess2_2, guess2_3, guess2_4)
  var guess3 = ListBuffer(guess3_1, guess3_2, guess3_3, guess3_4)
  var guess4 = ListBuffer(guess4_1, guess4_2, guess4_3, guess4_4)
  var guess5 = ListBuffer(guess5_1, guess5_2, guess5_3, guess5_4)
  var guess6 = ListBuffer(guess6_1, guess6_2, guess6_3, guess6_4)
  var guess7 = ListBuffer(guess7_1, guess7_2, guess7_3, guess7_4)
  var guess8 = ListBuffer(guess8_1, guess8_2, guess8_3, guess8_4)
  var guess9 = ListBuffer(guess9_1, guess9_2, guess9_3, guess9_4)
  var guess10 = ListBuffer(guess10_1, guess10_2, guess10_3, guess10_4)
  var feedback1 = ListBuffer(feedback1_1, feedback1_2, feedback1_3, feedback1_4)
  var feedback2 = ListBuffer(feedback2_1, feedback2_2, feedback2_3, feedback2_4)
  var feedback3 = ListBuffer(feedback3_1, feedback3_2, feedback3_3, feedback3_4)
  var feedback4 = ListBuffer(feedback4_1, feedback4_2, feedback4_3, feedback4_4)
  var feedback5 = ListBuffer(feedback5_1, feedback5_2, feedback5_3, feedback5_4)
  var feedback6 = ListBuffer(feedback6_1, feedback6_2, feedback6_3, feedback6_4)
  var feedback7 = ListBuffer(feedback7_1, feedback7_2, feedback7_3, feedback7_4)
  var feedback8 = ListBuffer(feedback8_1, feedback8_2, feedback8_3, feedback8_4)
  var feedback9 = ListBuffer(feedback9_1, feedback9_2, feedback9_3, feedback9_4)
  var feedback10 = ListBuffer(feedback10_1, feedback10_2, feedback10_3, feedback10_4)
  var gridPaneList = ListBuffer(gridPane1, gridPane2, gridPane3, gridPane4, gridPane5, gridPane6, gridPane7, gridPane8, gridPane9, gridPane10)

  //Starts the game
  var game = new Final()
  enableFirstRow()
  showCurrentRow()

  //Only enables first row on the grid
  def enableFirstRow() {
    gridPaneList(0).disable.value = false
    for (i <- 1 to 9){
      gridPaneList(i).disable.value = true
    }
  }

  //Enables subsequent rows on the grid
  def enableNextRow() {
    for (i <- 0 to 9){
      if (game.player.guessCount == i+1){
        gridPaneList(i).disable.value = true
        gridPaneList(i+1).disable.value = false
      }
    }
  }

  //Displays final answer
  def showAnswer(){
    for (i <- 0 to 3){
      answerList(i).setOpacity(1)
      answerList(i).setFill(Color.web(game.player.grid.answer(i).hexValue))
    }
  }

  //When user clicks new game
  def handleNewGame(action: ActionEvent){
    game = new Final()
    clearGuess()
    clearGuessView()
    clearFeedback()
    clearFeedbackView()
    enableFirstRow()
    showCurrentRow()
  }

  //When user clicks exit
  def handleLeaveGame(action: ActionEvent){
    MainApp.showMainMenu()
  }

  //Checks user guess
  def handleCheck(action: ActionEvent){
    game.player.guessCount += 1

    //Correct guess
    if (game.player.guess == game.player.grid.answer){
      game.player.won = true
      showAnswer()
      for (i <- 0 to 3){
        game.player.feedback.update(i, game.player.grid.feedbackColors(0))
      }
      showFeedback()
      MainApp.showFinalMessage(game.isWon())
    }
    //Wrong guess
    else {
      var answerClone = game.player.grid.answer.clone()
      //Checks if correct color, correct position
      for (i <- 0 to 3){
        if (game.player.guess(i) == game.player.grid.answer(i)){
          game.player.feedback.append(game.player.grid.feedbackColors(0))
          game.player.feedback.remove(0)
          answerClone -= game.player.guess(i)
        }
      }

      //Checks if correct color, wrong position
      for (i <- 0 to 3){
        if (answerClone.contains(game.player.guess(i))){
          game.player.feedback.append(game.player.grid.feedbackColors(1))
          game.player.feedback.remove(0)
          answerClone -= game.player.guess(i)
        }
      }

      //Wrong color, feedback given
      for (i <- answerClone){
        game.player.feedback.append(game.player.grid.feedbackColors(2))
        game.player.feedback.remove(0)
      }

      showFeedback()
      showCurrentRow()
      clearGuess()
      clearFeedback()

      //If player lost
      if (game.player.guessCount == game.player.grid.rows){
        game.player.won = false
        showAnswer()
        MainApp.showFinalMessage(game.isWon())
      }
      else { //If player haven't lost
        enableNextRow()
      }
    }
  }

  def clearGuess(){ //Sets guess list to all white colors
    for (i <- 0 to 3){
      game.player.guess.update(i, game.player.grid.feedbackColors(2))
    }
  }

  def clearGuessView(){ //Sets all guess opacity to 0 and color to white
    for (i <- 0 to 3){
      guess1(i).setOpacity(0)
      guess2(i).setOpacity(0)
      guess3(i).setOpacity(0)
      guess4(i).setOpacity(0)
      guess5(i).setOpacity(0)
      guess6(i).setOpacity(0)
      guess7(i).setOpacity(0)
      guess8(i).setOpacity(0)
      guess9(i).setOpacity(0)
      guess10(i).setOpacity(0)
      guess1(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      guess2(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      guess3(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      guess4(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      guess5(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      guess6(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      guess7(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      guess8(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      guess9(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      guess10(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
    }
  }

  def clearFeedback(){ //Sets feedback list to all white colors
    for (i <- 0 to 3){
      game.player.feedback.update(i, game.player.grid.feedbackColors(2))
    }
  }

  def clearFeedbackView(){ //Sets all feedback opacity to 0 and colors to white
    for (i <- 0 to 3){
      feedback1(i).setOpacity(0)
      feedback2(i).setOpacity(0)
      feedback3(i).setOpacity(0)
      feedback4(i).setOpacity(0)
      feedback5(i).setOpacity(0)
      feedback6(i).setOpacity(0)
      feedback7(i).setOpacity(0)
      feedback8(i).setOpacity(0)
      feedback9(i).setOpacity(0)
      feedback10(i).setOpacity(0)
      feedback1(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      feedback2(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      feedback3(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      feedback4(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      feedback5(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      feedback6(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      feedback7(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      feedback8(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      feedback9(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
      feedback10(i).setFill(Color.web(game.player.grid.feedbackColors(2).hexValue))
    }
  }

  //When user clicks on a color
  def copyColor1(){
    game.player.colorSelected = game.player.grid.colorList(0)
  }
  def copyColor2(){
    game.player.colorSelected = game.player.grid.colorList(1)
  }
  def copyColor3(){
    game.player.colorSelected = game.player.grid.colorList(2)
  }
  def copyColor4(){
    game.player.colorSelected = game.player.grid.colorList(3)
  }
  def copyColor5(){
    game.player.colorSelected = game.player.grid.colorList(4)
  }
  def copyColor6(){
    game.player.colorSelected = game.player.grid.colorList(5)
  }
  def copyColor7(){
    game.player.colorSelected = game.player.grid.colorList(6)
  }

  //When user places the colors on the grid
  def pasteColor1(){
    game.player.guess.update(0, game.player.colorSelected)
    if (game.player.guessCount == 0){
      guess1_1.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 1){
      guess2_1.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 2){
      guess3_1.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 3){
      guess4_1.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 4){
      guess5_1.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 5){
      guess6_1.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 6){
      guess7_1.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 7){
      guess8_1.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 8){
      guess9_1.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 9){
      guess10_1.setFill(Color.web(game.player.colorSelected.hexValue))
    }
  }
  def pasteColor2(){
    game.player.guess.update(1, game.player.colorSelected)
    if (game.player.guessCount == 0){
      guess1_2.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 1){
      guess2_2.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 2){
      guess3_2.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 3){
      guess4_2.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 4){
      guess5_2.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 5){
      guess6_2.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 6){
      guess7_2.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 7){
      guess8_2.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 8){
      guess9_2.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 9){
      guess10_2.setFill(Color.web(game.player.colorSelected.hexValue))
    }
  }
  def pasteColor3(){
    game.player.guess.update(2, game.player.colorSelected)
    if (game.player.guessCount == 0){
      guess1_3.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 1){
      guess2_3.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 2){
      guess3_3.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 3){
      guess4_3.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 4){
      guess5_3.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 5){
      guess6_3.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 6){
      guess7_3.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 7){
      guess8_3.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 8){
      guess9_3.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 9){
      guess10_3.setFill(Color.web(game.player.colorSelected.hexValue))
    }
  }
  def pasteColor4(){
    game.player.guess.update(3, game.player.colorSelected)
    if (game.player.guessCount == 0){
      guess1_4.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 1){
      guess2_4.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 2){
      guess3_4.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 3){
      guess4_4.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 4){
      guess5_4.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 5){
      guess6_4.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 6){
      guess7_4.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 7){
      guess8_4.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 8){
      guess9_4.setFill(Color.web(game.player.colorSelected.hexValue))
    } else if (game.player.guessCount == 9){
      guess10_4.setFill(Color.web(game.player.colorSelected.hexValue))
    }
  }

  //Provide feedback
  def showFeedback(){
    if (game.player.guessCount == 1){
      for (i <- 0 to 3){
        feedback1(i).setOpacity(1)
        feedback1(i).setFill(Color.web(game.player.feedback(i).hexValue))
      }
    } else if (game.player.guessCount == 2){
      for (i <- 0 to 3){
        feedback2(i).setOpacity(1)
        feedback2(i).setFill(Color.web(game.player.feedback(i).hexValue))
      }
    } else if (game.player.guessCount == 3){
      for (i <- 0 to 3){
        feedback3(i).setOpacity(1)
        feedback3(i).setFill(Color.web(game.player.feedback(i).hexValue))
      }
    } else if (game.player.guessCount == 4){
      for (i <- 0 to 3){
        feedback4(i).setOpacity(1)
        feedback4(i).setFill(Color.web(game.player.feedback(i).hexValue))
      }
    } else if (game.player.guessCount == 5){
      for (i <- 0 to 3){
        feedback5(i).setOpacity(1)
        feedback5(i).setFill(Color.web(game.player.feedback(i).hexValue))
      }
    } else if (game.player.guessCount == 6){
      for (i <- 0 to 3){
        feedback6(i).setOpacity(1)
        feedback6(i).setFill(Color.web(game.player.feedback(i).hexValue))
      }
    } else if (game.player.guessCount == 7){
      for (i <- 0 to 3){
        feedback7(i).setOpacity(1)
        feedback7(i).setFill(Color.web(game.player.feedback(i).hexValue))
      }
    } else if (game.player.guessCount == 8){
      for (i <- 0 to 3){
        feedback8(i).setOpacity(1)
        feedback8(i).setFill(Color.web(game.player.feedback(i).hexValue))
      }
    } else if (game.player.guessCount == 9){
      for (i <- 0 to 3){
        feedback9(i).setOpacity(1)
        feedback9(i).setFill(Color.web(game.player.feedback(i).hexValue))
      }
    } else if (game.player.guessCount == 10){
      for (i <- 0 to 3){
        feedback10(i).setOpacity(1)
        feedback10(i).setFill(Color.web(game.player.feedback(i).hexValue))
      }
    }
  }

  //Change opacity of current row to 1
  def showCurrentRow(){
    if (game.player.guessCount == 0){
      for (i <- 0 to 3){
        guess1(i).setOpacity(1)
      }
    } else if (game.player.guessCount == 1){
      for (i <- 0 to 3){
        guess2(i).setOpacity(1)
      }
    } else if (game.player.guessCount == 2){
      for (i <- 0 to 3){
        guess3(i).setOpacity(1)
      }
    } else if (game.player.guessCount == 3){
      for (i <- 0 to 3){
        guess4(i).setOpacity(1)
      }
    } else if (game.player.guessCount == 4){
      for (i <- 0 to 3){
        guess5(i).setOpacity(1)
      }
    } else if (game.player.guessCount == 5){
      for (i <- 0 to 3){
        guess6(i).setOpacity(1)
      }
    } else if (game.player.guessCount == 6){
      for (i <- 0 to 3){
        guess7(i).setOpacity(1)
      }
    } else if (game.player.guessCount == 7){
      for (i <- 0 to 3){
        guess8(i).setOpacity(1)
      }
    } else if (game.player.guessCount == 8){
      for (i <- 0 to 3){
        guess9(i).setOpacity(1)
      }
    } else if (game.player.guessCount == 9){
      for (i <- 0 to 3){
        guess10(i).setOpacity(1)
      }
    }
  }
}
