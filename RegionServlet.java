import for_db.ht14.CountryRepo;
import for_db.ht14.RegionRepo;
import javaClasses.ht14.Region;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RegionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegionRepo regionRepo = new RegionRepo();
        String id = req.getParameter("country");
        System.out.println(id);

        List<Region> regions = regionRepo.findAllByCountry(Integer.parseInt(id));
        StringBuilder stringBuilder = new StringBuilder();
        for (Region region : regions) {
            stringBuilder.append(region.getId() + ",");
            stringBuilder.append(region.getName() + ",");
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(stringBuilder.toString());
    }
}
