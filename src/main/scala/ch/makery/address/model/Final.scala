package ch.makery.address.model

class Final {
  val player = new User()

  def isWon(): Boolean = {
    if (player.won){
      true
    }
    else {
      false
    }
  }
}