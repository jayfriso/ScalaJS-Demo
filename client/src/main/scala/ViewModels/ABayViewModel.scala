package ViewModels

import shared.models.Item
import scala.scalajs.js.annotation.JSExportAll
import KnockoutJS._
import scala.scalajs.js
import scala.scalajs.js.JSConverters._
/**
  * Created by Jay Friso on 2016-08-29.
  */

@JSExportAll //Exports this class to a javascript object
class ABayViewModel(items: List[Item]) {
  val itemsAsJsArray : js.Array[js.Object]= items.map(_.asInstanceOf[js.Object]).toJSArray
  var availableItems : KnockoutObservableArray[js.Object] = Knockout.observableArray(itemsAsJsArray)

  //Change the items that are available
  def reApplyItems(items: List[Item]): Unit = {
    val newItemsAsJsArray = items.map(_.asInstanceOf[js.Object]).toJSArray
    availableItems(newItemsAsJsArray)
  }
}

