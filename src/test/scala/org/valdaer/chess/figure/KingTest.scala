package org.valdaer.chess.figure

import org.scalatest.FunSuite

/**
 * User: valdaer
 * Date: 12/8/13
 */
class KingTest extends FunSuite {
  val king = new King((2, 3))

  test(s"${king.toString} is threatening horizontally a figure at position 2d") {
    assert(king.isThreatening((2, 4)) == true)
  }

  test(s"${king.toString} is threatening vertically a figure at position 3c") {
    assert(king.isThreatening((3, 3)) == true)
  }

  test(s"${king.toString} is threatening diagonally a figure at position 1d") {
    assert(king.isThreatening((1, 4)) == true)
  }

  test(s"${king.toString} is not threatening a figure at position 4b") {
    assert(king.isThreatening((4, 2)) == false)
  }
}