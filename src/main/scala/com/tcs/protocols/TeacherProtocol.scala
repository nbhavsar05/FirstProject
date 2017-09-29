package com.tcs.protocols

object TeacherProtocol {

  case class TeacherQuoteRequest(quoteString:String)
  case class TeacherQuoteResponse(quoteString:String)

}
