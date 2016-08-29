package shared.models


import scala.annotation.meta.field
import scala.scalajs.js.annotation.{JSExport}
import org.scalajs.testinterface.TestUtils._

/**
  * Created by Jay Friso on 2016-08-28.
  */
@JSExport
case class Item (
                  @(JSExport @field) name: String,
                  @(JSExport @field) price: Double)

object Item {
  val availableItems = List(
    Item("HDMI-cable", 10D),
    Item("VGA-cable", 5.75D),
    Item("DVD", 25D),
    Item("Book", 15D),
    Item("aPhone", 500D),
    Item("Y-BOX360", 400D)
  )
}