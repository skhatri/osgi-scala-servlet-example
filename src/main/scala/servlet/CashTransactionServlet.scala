package servlet

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import javax.servlet.ServletConfig
import util.CashTransaction
import org.osgi.framework.FrameworkUtil

class CashTransactionServlet extends HttpServlet {

  var cashService: CashTransaction = null

  override def init(config: ServletConfig) {
    val ctx = FrameworkUtil.getBundle(this.getClass).getBundleContext
    println("context ")
    val ref = ctx.getServiceReference(classOf[CashTransaction].getName)
    cashService = ctx.getService(ref).asInstanceOf[CashTransaction]
    super.init(config)
  }

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    val writer = resp.getWriter
    println("get cash service ")
    writer.write(cashService.find("1"))
    writer.flush()
    writer.close()
  }
}
