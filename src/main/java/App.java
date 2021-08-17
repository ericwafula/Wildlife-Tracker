import java.util.List;
import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        // homepage
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //all animals
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //post submission
        post("/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
