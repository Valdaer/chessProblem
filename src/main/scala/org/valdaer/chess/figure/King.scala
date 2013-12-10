package org.valdaer.chess.figure

import Figure._

/**
 * User: valdaer
 * Date: 12/8/13
 */
case class King(p: Position) extends Figure(p) {
  def isThreatening(coordinates: Position): Boolean = isKingThreatening(position, coordinates)
}
