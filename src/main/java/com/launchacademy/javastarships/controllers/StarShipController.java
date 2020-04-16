package com.launchacademy.javastarships.controllers;


import com.launchacademy.javastarships.models.StarShip;
import com.launchacademy.javastarships.services.StarShipService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping ("/starships")
public class StarShipController {

  private StarShipService starShipService;

  public StarShipController() {
    starShipService = new StarShipService();
  }

//  @Autowired
//  StarShipService starShipService;

  @GetMapping("/show/{id}")
  public String showStarship (@PathVariable Integer id,  Model model) {
    StarShip starShip = starShipService.get(id);

    String fuelCss = "";
    if (starShip.getFuelCapacity() > 700) {
      fuelCss= "high-capacity";
    } else if (starShip.getFuelCapacity() > 300) {
      fuelCss=  "average-capacity";
    } else {
      fuelCss = "low-capacity";
    }

    model.addAttribute("fuelCss", fuelCss);
    model.addAttribute(starShip);
    return "starship/show";
  }

 @GetMapping
  public String listStarships(Model model){
    List <StarShip> starShips = starShipService.findAll();
    model.addAttribute("starShips" , starShips);
    return "starship/index";
 }

 @GetMapping("/new")
  public String addStarShip(Model model) {
    StarShip starShip = new StarShip();
    model.addAttribute("starShip", starShip);
    return ("starship/new");
 }

 @PostMapping
  public String saveStarShip(@ModelAttribute StarShip starShip, Model model) {
    starShipService.add(starShip);
    model.addAttribute(starShip);
   return "redirect:/starships";
 }
}
