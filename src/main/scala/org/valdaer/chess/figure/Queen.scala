package org.valdaer.chess.figure

import Figure._

/**
 * User: valdaer
 * Date: 12/8/13
 */
case class Queen(p: Position) extends Figure(p) {
  def isThreatening(coordinates: Position): Boolean = isQueenThreatening(position, coordinates)
}
