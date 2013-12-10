package org.valdaer.chess

/**
 * User: valdaer
 * Date: 12/8/13
 */
object ChessProblem extends App {
  val M = 7
  val N = 7
//  val definedFigures = "KKR".toCharArray.toList
//  val definedFigures = "NNNNRR".toCharArray.toList
  val definedFigures = "KKQQBBN".toCharArray.toList
  val chess = new Chess(M, N)
  val results = chess.getUniqueConfigurations(definedFigures)

  for (result <- results) {
    println(result)
  }

  println(s"\n\nThere are ${results.size} unique configurations for ${definedFigures} set on ${M} x ${N} board.")
}
