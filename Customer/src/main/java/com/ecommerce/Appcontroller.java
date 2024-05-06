package com.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Appcontroller {

	@Autowired
	private CustomerData data;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Customer> listCustomer = data.listAll();
		model.addAttribute("listCustomer", listCustomer);
		return "index";
	}

	@RequestMapping("/new")
	public String showNewCustomerFrom(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", new Customer());
		return "new_customer";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("Customer") Customer customer) {
		data.save(customer);
		return "redirect:/";
	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView showEdit(@PathVariable(name = "id") Long id) {
		ModelAndView mv = new ModelAndView("edit_customer");
		Customer customer = data.get(id);
		mv.addObject("Customer", customer);
		return mv;
	}

	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable(name = "id") Long id) {
		data.delete(id);
		return "redirect:/";
	}

}
