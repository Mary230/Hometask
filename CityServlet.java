import for_db.ht14.CityRepo;
import for_db.ht14.CountryRepo;
import javaClasses.ht14.City;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CityServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CityRepo cr = new CityRepo();
        String id = request.getParameter("region");
        System.out.println(id);

        List<City> cities = cr.findAllByRegion(Integer.parseInt(id));
        StringBuilder stringBuilder = new StringBuilder();
        for (City city : cities) {
            stringBuilder.append(city.getCity_id() + ",");
            stringBuilder.append(city.getName() + ",");
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(stringBuilder.toString());
    }
}
