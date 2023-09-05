package ch.makery.address.model

abstract class Color {
  val color: String
  val hexValue: String
}

class ColorRed extends Color{
  val color = "red"
  val hexValue = "#ff0000"
}

class ColorBlue extends Color{
  val color = "blue"
  val hexValue = "#0000ff"
}

class ColorPink extends Color{
  val color = "pink"
  val hexValue = "#ff26e7"
}

class ColorGreen extends Color{
  val color = "green"
  val hexValue = "#27ff37"
}

class ColorOrange extends Color{
  val color = "orange"
  val hexValue = "#f28c28"
}

class ColorBlack extends Color{
  val color = "black"
  val hexValue = "#000000"
}

class ColorYellow extends Color{
  val color = "yellow"
  val hexValue = "#ffee22"
}

class ColorGrey extends Color{
  val color = "grey"
  val hexValue = "#808080"
}

class ColorWhite extends Color{
  val color = "white"
  val hexValue = "#ffffff"
}