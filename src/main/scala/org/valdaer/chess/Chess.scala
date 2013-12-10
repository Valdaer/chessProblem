package org.valdaer.chess

import org.valdaer.chess.figure.Figure
import Figure._

/**
 * User: valdaer
 * Date: 12/7/13
 */
class Chess(rowSize: Int, columnSize: Int) {

  def getUniqueConfigurations(definedFigures: List[Char]): Set[Set[Figure]] = {
    def uniqueConfigurations(df: List[Char]): Set[Set[Figure]] = df match {
      case List() => Set(Set())
      case _ =>
        for {
          figures <- uniqueConfigurations(df.tail)
          x <- 1 to rowSize
          y <- 1 to columnSize
          coordinates = (x, y)
          definedFigure = df.head.toString
          if isSafeToPlace(coordinates, definedFigure, figures)
        } yield figures + createFigure(definedFigure, coordinates)
    }

    uniqueConfigurations(definedFigures)
  }
}



