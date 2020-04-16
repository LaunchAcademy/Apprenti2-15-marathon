package com.launchacademy.javastarships.services;

import com.launchacademy.javastarships.models.StarShip;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class StarShipService {
  List<StarShip> starShips;

  public StarShipService() {
    this.starShips = new ArrayList<StarShip>();
  }

  public List<StarShip> findAll() {
    StarShip starShip = new StarShip();

    starShip.setId(0);
    starShip.setName("Rocinante");
    starShip.setDescription("Mars built for Tilting at Windmills");
    starShip.setFuelCapacity(250);
    starShips.add(starShip);


    starShip = new StarShip();
    starShip.setId(1);
    starShip.setName("Moya");
    starShip.setDescription("Leviathan transport vessel; a living sentient bio-mechanical space ship. ");
    starShip.setFuelCapacity(633);
    starShips.add(starShip);

    starShip = new StarShip();
    starShip.setId(2);
    starShip.setName("Lexx");
    starShip.setDescription("Enormous sentient insect genetically modified for space travel and planet-destroying capabilities.");
    starShip.setFuelCapacity(1000);
    starShips.add(starShip);

    return starShips;
  }

  public StarShip get(Integer index) {
    return findAll().get(index);
  }

  public void add(StarShip starShip) {
    starShips.add(starShip);
  }
}
