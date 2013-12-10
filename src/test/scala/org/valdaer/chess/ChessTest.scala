package org.valdaer.chess

import org.scalatest.FunSuite
import org.valdaer.chess.figure._

/**
 * User: valdaer
 * Date: 12/10/13
 */
class ChessTest extends FunSuite {
  test("test for 3×3 board containing 2 Kings and 1 Rook") {
    val chess = new Chess(3, 3)
    val definedFigures = "KKR".toCharArray.toList
    val expected = Set(Set(Rook((2,1)), King((1,3)), King((3,3))), Set(Rook((1,2)), King((3,3)), King((3,1))), Set(Rook((2,3)), King((3,1)), King((1,1))), Set(Rook((3,2)), King((1,3)), King((1,1))))

    assert(chess.getUniqueConfigurations(definedFigures) == expected)
  }

  test("test for 4×4 board containing 2 Rooks and 4 Knights") {
    val chess = new Chess(4, 4)
    val definedFigures = "NNNNRR".toCharArray.toList
    val expected = Set(Set(Rook((3,2)), Knight((2,3)), Knight((4,1)), Knight((2,1)), Knight((4,3)), Rook((1,4))), Set(Knight((3,3)), Rook((2,2)), Knight((1,3)), Knight((3,1)), Rook((4,4)), Knight((1,1))), Set(Knight((2,2)), Rook((1,3)), Rook((3,1)), Knight((4,4)), Knight((2,4)), Knight((4,2))), Set(Knight((2,3)), Knight((4,1)), Knight((2,1)), Knight((4,3)), Rook((1,2)), Rook((3,4))), Set(Rook((3,3)), Knight((2,2)), Knight((4,4)), Knight((2,4)), Rook((1,1)), Knight((4,2))), Set(Knight((3,3)), Knight((1,3)), Knight((3,1)), Rook((2,4)), Knight((1,1)), Rook((4,2))), Set(Knight((3,2)), Rook((2,3)), Rook((4,1)), Knight((1,2)), Knight((1,4)), Knight((3,4))), Set(Knight((3,2)), Rook((2,1)), Rook((4,3)), Knight((1,2)), Knight((1,4)), Knight((3,4))))

    assert(chess.getUniqueConfigurations(definedFigures) == expected)
  }
}
