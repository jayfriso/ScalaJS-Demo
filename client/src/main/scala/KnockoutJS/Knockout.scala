package KnockoutJS

import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Created by Jay Friso on 2016-08-29.
  */
@JSName("ko")
object Knockout extends js.Object {

  def observable[T](value: T): KnockoutObservable[T] = js.native
  def computed[T](fn: js.Function0[T]): KnockoutComputed[T] = js.native
  def observableArray[T](array: js.Array[T]): KnockoutObservableArray[T] = js.native

  def applyBindings(viewModelOrBindingContext: Object): Unit = js.native
  def applyBindings(viewModelOrBindingContext: Object, rootNode: dom.Element): Unit = js.native
}
