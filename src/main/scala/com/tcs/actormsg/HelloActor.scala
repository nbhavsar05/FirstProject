package com.tcs.actormsg

import akka.actor.{Actor, ActorSystem, Props}

case class Greeting(msg:String,name:String)

class HelloActor extends Actor {

  def receive = {

    case g: Greeting => println(s"hello ${g.name}")

  }

}

  object main {

    def main(args:Array[String]):Unit = {

      val system = ActorSystem("HelloSystem")
      val helloActor=system.actorOf(Props[HelloActor],name="helloActor")
      helloActor ! Greeting("Welcome to Scala with AKKA","Tom")

    }

  }


