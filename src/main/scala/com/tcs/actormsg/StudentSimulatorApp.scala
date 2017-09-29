package com.tcs.actormsg

import akka.actor.{ActorRef, ActorSystem, Props, actorRef2Scala}
import com.tcs.protocols.StudentProtocol.{StudentQuoteRequest}





  object StudentSimulatorApp extends App{


    val studentActorSystem=ActorSystem("StudentSystem")


    val studentActorRef=studentActorSystem.actorOf(Props[StudentActor],name="studentActorRef")


    //Initialize the ActorSystem
    val teacherActorSystem=ActorSystem("TeacherSystem")

    //construct the Teacher Actor Ref
    val teacherActorRef=teacherActorSystem.actorOf(Props(new TeacherActor(studentActorRef)),name="teacherActorRef")




    teacherActorRef ! StudentQuoteRequest("Hi Madam Shall I mail u the assignments?")





    //Let's wait for a couple of seconds before we shut down the system
    Thread.sleep (2000)

    //Shut down the ActorSystem.
    //actorSystem.shutdown()


    teacherActorSystem.stop(teacherActorRef)
    studentActorSystem.stop(studentActorRef)
    //teacherActorSystem.shutdown()

  }



