package com.tcs.actormsg

import akka.actor.SupervisorStrategy.{Restart, Stop}
import akka.actor.{Actor, ActorInitializationException, ActorKilledException, ActorRef, DeathPactException, OneForOneStrategy}
import com.tcs.protocols.StudentProtocol.StudentQuoteRequest
import com.tcs.protocols.TeacherProtocol.TeacherQuoteRequest


class TeacherActor(studentActor:ActorRef) extends Actor {


  override val supervisorStrategy=OneForOneStrategy() {

    case _: ActorInitializationException=> Stop
    case _: ActorKilledException        => Stop
    case _: DeathPactException             => Stop
    case _: Exception                   => Restart

  }


    def receive = {

      case request : StudentQuoteRequest =>{
        println (s"Student request= ${request.quoteString}")
        studentActor ! TeacherQuoteRequest("Yes u can")

      }
      case msg:String =>{
        println(msg)
        context.stop(self)
      }
      case _ => println("Something went wrong.")

    }

  }



