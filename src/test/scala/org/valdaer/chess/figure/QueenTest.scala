package org.valdaer.chess.figure

import org.scalatest.FunSuite

/**
 * User: valdaer
 * Date: 12/8/13
 */
class QueenTest extends FunSuite {
  val queen = new Queen((4, 3))

  test(s"${queen.toString} is threatening horizontally a figure at position 4g") {
    assert(queen.isThreatening((4, 7)) == true)
  }

  test(s"${queen.toString} is threatening vertically a figure at position 1c") {
    assert(queen.isThreatening((1, 3)) == true)
  }

  test(s"${queen.toString} is threatening diagonally a figure at position 2e") {
    assert(queen.isThreatening((2, 5)) == true)
  }

  test(s"${queen.toString} is not threatening a figure at position 2b") {
    assert(queen.isThreatening((2, 2)) == false)
  }
}
