package com.abhi.akka.client

import akka.actor.ActorSystem
import akka.pattern.ask
import akka.util.Timeout
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
    val keyValueActorRef = system.actorSelection("akka.tcp://keyvalue@127.0.0.1:2552")
    keyValueActorRef ! SetRequest("foo", "bar")
    (keyValueActorRef ? GetRequest("foo")).onSuccess({
      case x : KeyValue => println(s"got value ${x.value}")
    })
  }
}
