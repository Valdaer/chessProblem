package org.valdaer.chess.figure

import org.scalatest.FunSuite

/**
 * User: valdaer
 * Date: 12/8/13
 */
class KnightTest extends FunSuite {
  val knight = new Knight((3, 5))

  test(s"${knight.toString} is threatening horizontally a figure at position 4c") {
    assert(knight.isThreatening((4, 3)) == true)
  }

  test(s"${knight.toString} is threatening vertically a figure at position 5f") {
    assert(knight.isThreatening((5, 6)) == true)
  }

  test(s"${knight.toString} is not threatening a figure at position 3c") {
    assert(knight.isThreatening((3, 3)) == false)
  }
}
