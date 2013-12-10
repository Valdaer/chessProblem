package org.valdaer.chess.figure

import org.valdaer.chess.figure.Figure._

/**
 * User: valdaer
 * Date: 12/8/13
 */
abstract class Figure(val position: Position) {

  def isThreatening(coordinates: Position): Boolean

  def isOnTheSamePosition(coordinates: Position): Boolean = position._1 == coordinates._1 && position._2 == coordinates._2

  override def toString = this.getClass.getSimpleName + " " + position._1 + mapToChessCoordinate(position._2)
}

object Figure {
  type Position = (Int, Int)

  def isKingThreatening(kingPosition: Position, coordinates: Position): Boolean = {
    kingPosition._1 == coordinates._1 && (kingPosition._2 - coordinates._2).abs == 1 ||
    kingPosition._2 == coordinates._2 && (kingPosition._1 - coordinates._1).abs == 1 ||
    (kingPosition._1 - coordinates._1).abs == 1 && (kingPosition._2 - coordinates._2).abs == 1
  }

  def isQueenThreatening(queenPosition: Position, coordinates: Position): Boolean = {
    queenPosition._1 == coordinates._1 ||
    queenPosition._2 == coordinates._2 ||
    (queenPosition._1 - coordinates._1).abs == (queenPosition._2 - coordinates._2).abs
  }

  def isBishopThreatening(bishopPosition: Position, coordinates: Position): Boolean =
  (bishopPosition._1 - coordinates._1).abs == (bishopPosition._2 - coordinates._2).abs

  def isKnightThreatening(knightPosition: Position, coordinates: Position): Boolean = {
    (knightPosition._1 - coordinates._1).abs == 1 && (knightPosition._2 - coordinates._2).abs == 2 ||
    (knightPosition._2 - coordinates._2).abs == 1 && (knightPosition._1 - coordinates._1).abs == 2
  }

  def isRookThreatening(rookPosition: Position, coordinates: Position): Boolean =
  rookPosition._1 == coordinates._1 || rookPosition._2 == coordinates._2

  def isFigureThreatening(l: String): (Position, Position) => Boolean = l match {
    case "K" => isKingThreatening
    case "Q" => isQueenThreatening
    case "B" => isBishopThreatening
    case "N" => isKnightThreatening
    case "R" => isRookThreatening
    case _ =>
      throw new IllegalArgumentException
  }

  def createFigure(l: String, position: Position): Figure = l match {
    case "K" => new King(position)
    case "Q" => new Queen(position)
    case "B" => new Bishop(position)
    case "N" => new Knight(position)
    case "R" => new Rook(position)
    case _ =>
      throw new IllegalArgumentException
  }

  def isSafeToPlace(coordinates: Position, definedFigure: String, figures: Set[Figure]): Boolean = {
    def isOnTheSamePosition(position: Position, figures: Set[Figure]): Boolean = figures.exists(_.isOnTheSamePosition(position))

    def isAtThreat(position: Position, figures: Set[Figure]): Boolean = figures.exists(_.isThreatening(position))

    def isThreatening(position: Position, figures: Set[Figure], isFigureThreatening: (Position, Position) => Boolean): Boolean = {
      for (figure <- figures) {
        if (isFigureThreatening(position,figure.position))
          return true
      }
      false
    }

    if (figures.isEmpty) true
    else {
      !isOnTheSamePosition(coordinates, figures) &&
      !isAtThreat(coordinates, figures) &&
      !isThreatening(coordinates, figures, isFigureThreatening(definedFigure))
    }
  }

  def mapToChessCoordinate(c: Int): String = c match {
    case 1 => "a"
    case 2 => "b"
    case 3 => "c"
    case 4 => "d"
    case 5 => "e"
    case 6 => "f"
    case 7 => "g"
    case 8 => "h"
    case x => x.toString
  }
}
