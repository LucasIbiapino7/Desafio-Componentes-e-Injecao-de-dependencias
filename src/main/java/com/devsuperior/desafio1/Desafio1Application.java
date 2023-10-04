package com.devsuperior.desafio1;

import com.devsuperior.desafio1.entities.Order;
import com.devsuperior.desafio1.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {

	private OrderService orderService;

	public Desafio1Application(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

		int code = scanner.nextInt();
		double basic = scanner.nextDouble();
		double discount = scanner.nextDouble();

		Order order = new Order(code, basic, discount);
		System.out.println("Pedido Código " + order.getCode());
		System.out.printf("Valor Total: R$ %.2f", orderService.total(order));
	}
}
