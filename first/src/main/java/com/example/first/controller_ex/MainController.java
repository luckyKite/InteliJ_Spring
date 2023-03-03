package com.example.first.controller_ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
  @GetMapping("/main")
  public String main() {
    return "ex/main";
  }

  @GetMapping("/main1")
  public String main1(@RequestParam Map<String, String> param, Model model) {
    String id = param.get("id");
    String name = param.get("name");
    model.addAttribute("id", id);
    model.addAttribute("name", name);
    return "ex/main1";
  }

  @GetMapping("/main2")
  public String main2(@RequestParam(required = true, defaultValue = "a") String id, @RequestParam(value="name", defaultValue = "aaa", required = false) String name, Model model) {
    model.addAttribute("id", id);
    model.addAttribute("name", name);
    return "ex/main2";
  }
}
