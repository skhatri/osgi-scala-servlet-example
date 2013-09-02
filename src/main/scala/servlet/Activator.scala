package servlet

import org.osgi.framework.{BundleContext, BundleActivator}
import util.CashTransaction

class Activator extends BundleActivator {
  def start(context: BundleContext) {
    println("starting the bundle ")
    val ref = context.getServiceReference(classOf[CashTransaction].getName)
    val txn = context.getService(ref).asInstanceOf[CashTransaction]
    println(txn.find("test"))
  }

  def stop(context: BundleContext) {

  }
}
