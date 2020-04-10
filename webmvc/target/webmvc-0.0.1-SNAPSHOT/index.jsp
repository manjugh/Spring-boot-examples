<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.1">
    <jsp:scriptlet>
                    try ( java.io.InputStream is = getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF") ) {
                        if ( is != null ) {
                            java.util.jar.Manifest manifest = new java.util.jar.Manifest( is );
                            pageContext.setAttribute("manifestEntries", manifest.getMainAttributes().entrySet());
                        }
                    }
    </jsp:scriptlet>

    <html xmlns="http://www.w3.org/1999/xhtml">
    <body>
    <h2>Invoice (INV) Server</h2>

    <ul>
        <li><a href="services">JAX-WS services</a></li>
        <li><a href="api">JAX-RS services</a></li>
        <li><a href="actuator">actuator - see <a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints">spring boot actuator
            docs</a> for more administrative endpoints</a></li>
        <li><a href="hystrix">Hystrix dashboard</a></li>
        <li><a href="webjars/swagger-ui/index.html?url=/inv/swagger-v1.json">swagger-ui</a></li>
    </ul>

    <h2>MANIFEST.MF</h2>
    <c:choose>
        <c:when test="empty ${manifestEntries}">
            No manifest found
        </c:when>
        <c:otherwise>
            <c:forEach var="entry" items="${manifestEntries}">
                <c:out value="${entry.key}"/>: <c:out value="${entry.value}"/><br/>
            </c:forEach>
        </c:otherwise>
    </c:choose>

    </body>
    </html>
</jsp:root>
