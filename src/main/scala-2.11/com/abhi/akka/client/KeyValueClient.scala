package com.abhi.akka.client

import akka.actor.{Props, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import com.abhi.akka.actors.KeyValueActor
import com.abhi.akka.messages.{KeyValue, _}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by abhishek.srivastava on 1/10/16.
  */


object KeyValueClient {

  def main(args: Array[String]) : Unit = {
    implicit val system = ActorSystem("LocalFileSystem")
    implicit val timeout = Timeout(2 seconds)
    val actor = system.actorOf(Props[KeyValueActor], "keyvalue-db")
    actor ! SetRequest("foo", "bar")
    (actor ? GetRequest("foo")).onSuccess({
      case x : KeyValue => println(s"got value ${x.value}")
    })
  }
}
