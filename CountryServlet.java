import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import for_db.ht14.CountryRepo;
import javaClasses.ht14.Country;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CountryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CountryRepo countryRepo = new CountryRepo();
        List<Country> countries = countryRepo.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (Country country : countries) {
            stringBuilder.append(country.getId() + ",");
            stringBuilder.append(country.getName() + ",");
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(stringBuilder.toString());
    }
}






















//
//        CountryRepo cr = new CountryRepo();
//        Country myC = cr.findCountryByName(myCountry);
//
//        List<Country> countries = new ArrayList<>();
//        countries.add(myC);
//
//        List<Country> allCountries = cr.findAll();
//        for (Country country: allCountries) {
//            if (country.getName().compareTo(myCountry)!=0){
//                countries.add(country);
//            }
//        }
//
//        JsonObject jsonObject = new JsonObject();
//
//        JsonArray jsonArray = new JsonArray();
//
//        for (Country country: countries) {
//            jsonArray.add(new Gson().toJsonTree(country));
//        }
//
//        jsonObject.add("countries", jsonArray);
//
//        System.out.println(countries.size());
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        Gson gson = new Gson();
//        String json = gson.toJson(countries);
//        System.out.println(json);
