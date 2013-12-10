package org.valdaer.chess.figure

import org.scalatest.FunSuite
import Figure._

/**
 * User: valdaer
 * Date: 12/8/13
 */
class FigureTest extends FunSuite {
  test("isSafeToPlace when empty figures") {
    assert(isSafeToPlace((1, 1), "K", Set()) == true)
  }

  test("isSafeToPlace when is on the same position") {
    assert(isSafeToPlace((2, 2), "K", Set(Rook(2, 2))) == false)
  }

  test("isSafeToPlace when is at threat") {
    assert(isSafeToPlace((2, 6), "N", Set(Rook(2, 2), King(4, 3))) == false)
  }

  test("isSafeToPlace when is threatening") {
    assert(isSafeToPlace((2, 2), "B", Set(King(4, 4), Rook(1, 6))) == false)
  }

  test("isSafeToPlace when is safe") {
    assert(isSafeToPlace((2, 2), "R", Set(King(1, 4), Knight(3, 6), Bishop(5, 1))) == true)
  }
}
