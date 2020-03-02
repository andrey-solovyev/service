package service.Logic;

import service.Model.Order;
import service.Model.Person;
import service.Repository.OrderRepository;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Logic {
    public Logic() {
    }

    public void addNewOrder(String user_name, String user_surname, String email, String phone, String category, String warranty, String firm, String data, String state, String problem, String fullproblem, String master, OrderRepository orderRepo, Map<String, Object> model) {
      //  Map<Double, String> info = new HashMap<>();
     //   info.put(parseDouble(phone), email);
        String[] dateTime = data.split("-");
        Calendar calendar = new GregorianCalendar(parseInt(dateTime[0]), parseInt(dateTime[1]), parseInt(dateTime[2]));

        boolean warranties = false;
        if (warranty.equals("on")) {
            warranties = true;
        }

        Order order = new Order( warranties, category, firm, calendar, calendar, problem,fullproblem, state, master);
        Person person = new Person(order.getId(),user_name, phone, email);
        orderRepo.save(order);
        model.put("order", order);
        model.put("person",person);

    }
}
