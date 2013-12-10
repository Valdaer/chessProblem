package org.valdaer.chess.figure

import org.scalatest.FunSuite

/**
 * User: valdaer
 * Date: 12/8/13
 */
class RookTest extends  FunSuite {
  val rook = new Rook((1, 1))

  test(s"${rook.toString} is threatening horizontally a figure at position 1e") {
    assert(rook.isThreatening((1, 5)) == true)
  }

  test(s"${rook.toString} is threatening vertically a figure at position 4a") {
    assert(rook.isThreatening((4, 1)) == true)
  }

  test(s"${rook.toString} is not threatening a figure at position 2b") {
    assert(rook.isThreatening((2, 2)) == false)
  }
}
