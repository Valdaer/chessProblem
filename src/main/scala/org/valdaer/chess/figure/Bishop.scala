package org.valdaer.chess.figure

import Figure._

/**
 * User: valdaer
 * Date: 12/8/13
 */
case class Bishop(p: Position) extends Figure(p) {
  def isThreatening(coordinates: Position): Boolean = isBishopThreatening(position, coordinates)
}
