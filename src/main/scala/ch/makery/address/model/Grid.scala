package ch.makery.address.model

import scala.util.Random
import scala.collection.mutable.ListBuffer

class Grid {
  val colorList: ListBuffer[Color] = ListBuffer(new ColorRed, new ColorBlue, new ColorPink, new ColorGreen, new ColorOrange, new ColorBlack, new ColorYellow)
  val feedbackColors: ListBuffer[Color] = ListBuffer(new ColorBlack, new ColorGrey, new ColorWhite)
  val rows: Int = 10
  var answer: ListBuffer[Color] = ListBuffer[Color]()

  answer = generateAnswer()

  def generateAnswer(): ListBuffer[Color] = {
    Random.shuffle(colorList).slice(0,4)
  }
}