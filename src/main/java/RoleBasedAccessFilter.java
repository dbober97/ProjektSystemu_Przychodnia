import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(urlPatterns = {"/admin/*", "/recepcjonista/*", "/lekarz/*"})
public class RoleBasedAccessFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        System.out.println("[FILTER] Otrzymano żądanie: " + uri);

        HttpSession session = req.getSession(false);
        System.out.println("[FILTER] Sesja: " + session);

        if (session != null) {
            System.out.println("[FILTER] Atrybuty w sesji:");
            Enumeration<String> attributeNames = session.getAttributeNames();
            while (attributeNames.hasMoreElements()) {
                String attrName = attributeNames.nextElement();
                Object attrValue = session.getAttribute(attrName);
                System.out.println("[FILTER] - " + attrName + " = " + attrValue);
            }
        }

        LoginBean loginBean = (session != null) ? (LoginBean) session.getAttribute("loginBean") : null;
        if (loginBean == null) {
            System.out.println("[FILTER] Brak loginBean w sesji – przekierowanie na index.xhtml");
            res.sendRedirect(req.getContextPath() + "/index.xhtml");
            return;
        }

        if (loginBean.getUser() == null) {
            System.out.println("[FILTER] loginBean istnieje, ale user jest null – przekierowanie na index.xhtml");
            res.sendRedirect(req.getContextPath() + "/index.xhtml");
            return;
        }

        String rola = loginBean.getRola();
        System.out.println("[FILTER] Rola użytkownika: " + rola);

        // Sprawdzenie ról i URI
        if (uri.contains("/admin/") && !"ADMINISTRATOR".equalsIgnoreCase(rola)) {
            System.out.println("[FILTER] Brak dostępu do /admin/ dla roli: " + rola);
            res.sendRedirect(req.getContextPath() + "/index.xhtml");
            return;
        }

        if (uri.contains("/recepcjonista/") && !"RECEPCJONISTA".equalsIgnoreCase(rola)) {
            System.out.println("[FILTER] Brak dostępu do /recepcjonista/ dla roli: " + rola);
            res.sendRedirect(req.getContextPath() + "/index.xhtml");
            return;
        }

        if (uri.contains("/lekarz/") && !"LEKARZ".equalsIgnoreCase(rola)) {
            System.out.println("[FILTER] Brak dostępu do /lekarz/ dla roli: " + rola);
            res.sendRedirect(req.getContextPath() + "/index.xhtml");
            return;
        }

        System.out.println("[FILTER] Rola i URI pasują – kontynuujemy przetwarzanie");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[FILTER] Inicjalizacja filtra");
    }

    @Override
    public void destroy() {
        System.out.println("[FILTER] Niszczenie filtra");
    }
}
