package com.tiendat.service02.Controller;

import com.tiendat.service02.Entity.Order;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.
        return "Hello from Order Service running at port: " + env.getProperty("local.server.port");
    }

    @RequestMapping("/{id}")
    public Order getOrder(@PathVariable final int id){
        //create order obj
        Order order = new Order();
        order.setId(id);

        // get list of available orders
        List<Object> products = restTemplate.getForObject("http://service01/products/", List.class);
        order.setProducts(products);

        return  order;
    }

    @RequestMapping("/admin")
    public String homeAdmin() {
        return "This is the admin area of Order service running at port: " + env.getProperty("local.server.port");
    }

}
