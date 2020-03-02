package service.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.Logic.Logic;
import service.Repository.OrderRepository;

import java.util.Map;

@Controller("/order")
public class OrderController {
    private OrderRepository orderRepository;
    private Logic logic;

    @GetMapping("id")
    public void getById() {

    }

    @GetMapping("Delete")
    public void deleteById(Integer id) {

    }

    @GetMapping
    public String main(Map<String, Object> model) {
        return "index.html";
    }

    @PostMapping("add")
    public String addOrder(@RequestParam String user_name, @RequestParam String user_surname, @RequestParam String email, @RequestParam String phone, @RequestParam String category, @RequestParam String warranty, @RequestParam String firm, @RequestParam String data, @RequestParam String state, @RequestParam String problem, @RequestParam String fullproblem, @RequestParam String master, Map<String, Object> model) {
        logic.addNewOrder(user_name, user_surname, email, phone, category, warranty, firm, data, state, problem, fullproblem, master, orderRepository, model);
        System.out.println(data);
        return "index";
    }

    @GetMapping("all")
    public Object[] allOrder() {
        return orderRepository.findAll().toArray();
    }

    @PostMapping("addOrder")
    public String GoAdd() {
        return "addNewOrder";
    }

    @GetMapping
    public String main() {
        return "index";
    }

}
