package ch.makery.address.model

import scala.collection.mutable.ListBuffer

class User {
  var guessCount: Int = 0
  var won: Boolean = false
  var guess: ListBuffer[Color] = ListBuffer(new ColorWhite, new ColorWhite, new ColorWhite, new ColorWhite)
  var feedback: ListBuffer[Color] = ListBuffer(new ColorWhite, new ColorWhite, new ColorWhite, new ColorWhite)
  var grid: Grid = new Grid()
  var colorSelected: Color = new ColorWhite
}