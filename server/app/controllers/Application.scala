package controllers

import play.api.Environment
import play.api.mvc._
import play.api.routing.JavaScriptReverseRouter
import shared.models.Item
import upickle.default.{read, write}

class Application()(implicit environment: Environment) extends Controller {

  def javascriptRoutes = Action { implicit request =>
    Ok(
      JavaScriptReverseRouter("jsRoutes")(
        routes.javascript.Application.getAvailableItems
      )
    ).as("text/javascript")
  }

  def index = Action {
    Ok(views.html.index("Abay App -Made with ScalaJS-"))
  }

  def getAvailableItems = Action { request =>
    Ok(write(Item.availableItems))
  }
}
