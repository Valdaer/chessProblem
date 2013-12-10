package org.valdaer.chess.figure

import Figure._

/**
 * User: valdaer
 * Date: 12/8/13
 */
case class Knight(p: Position) extends Figure(p) {
  def isThreatening(coordinates: Position): Boolean = isKnightThreatening(position, coordinates)
}
