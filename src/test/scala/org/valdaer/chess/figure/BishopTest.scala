package org.valdaer.chess.figure

import org.scalatest.FunSuite

/**
 * User: valdaer
 * Date: 12/8/13
 */
class BishopTest extends FunSuite {
  val bishop = new Bishop((3, 2))

  test(s"${bishop.toString} is threatening diagonally a figure at position 6e") {
    assert(bishop.isThreatening((6, 5)) == true)
  }

  test(s"${bishop.toString} is not threatening a figure at position 4d") {
    assert(bishop.isThreatening((4, 4)) == false)
  }
}
