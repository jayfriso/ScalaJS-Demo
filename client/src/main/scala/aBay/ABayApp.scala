package aBay

import ViewModels.ABayViewModel
import org.scalajs.dom.raw.{MouseEvent, Event, XMLHttpRequest}
import scala.scalajs.js
import org.scalajs.dom
import upickle.default.{read, write}
import KnockoutJS._

import shared.models.Item

import scala.scalajs.js.annotation.JSExport

object ABayApp extends js.JSApp {
  var allAvailableItems: List[Item] = List.empty[Item]
  var viewModel: ABayViewModel = null

  def main(): Unit = {
    val shoppingContainer: dom.Element = dom.document.getElementById("shopping-row")

    val xhr = new XMLHttpRequest()
    xhr.open("GET", "/getAvailableItems")
    xhr.onload = (e: Event) => {
      if (xhr.status == 200) {
        //Get the available items as a List of Items
        allAvailableItems = read[List[Item]](xhr.responseText)
        //Create a viewmodel to bind using this list
        viewModel = new ABayViewModel(allAvailableItems)
        Knockout.applyBindings(viewModel, shoppingContainer)
        }
    }
    xhr.send()

    val maxPriceButton: dom.html.Button = dom.document.getElementById("max-price-button").asInstanceOf[dom.html.Button]
    maxPriceButton.onclick = (mouseEvent: MouseEvent) => {
      val maxPrice: Double =  dom.document.getElementById("max-price-input").asInstanceOf[dom.html.Input].value.toDouble
      val filteredItems: List[Item] = allAvailableItems.filter(item => item.price <= maxPrice)
      viewModel.reApplyItems(filteredItems)
    }
  }


}
