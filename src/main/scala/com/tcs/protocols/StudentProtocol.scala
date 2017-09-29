package com.tcs.protocols

object StudentProtocol {

  case class StudentQuoteRequest(quoteString:String)
  case class StudentQuoteResponse(quoteString:String)

}
