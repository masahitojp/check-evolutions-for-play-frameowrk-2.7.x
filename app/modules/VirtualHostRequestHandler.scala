package modules

import javax.inject.Inject

import play.api.http.{DefaultHttpRequestHandler, HttpConfiguration, HttpErrorHandler, HttpFilters}
import play.api.mvc.RequestHeader
import play.api.routing.Router

class VirtualHostRequestHandler @Inject() (
    errorHandler: HttpErrorHandler,
    configuration: HttpConfiguration,
    filters: HttpFilters,
    router: Router
) extends DefaultHttpRequestHandler(
      router,
      errorHandler,
      configuration,
      filters
    ) {
  override def routeRequest(request: RequestHeader) = {
    request.host match {
      case "foo.example.com" => super.routeRequest(request)
      case _ => super.routeRequest(request)
    }
  }
}
