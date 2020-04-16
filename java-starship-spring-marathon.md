With so many ships now sailing the stars we really need a system to make sure everyone stays safe. Enter the SWA (Space Way Authority). Help the SWA build out some software to make their jobs easier!

## Getting Started

```no-highlight
et get java-starship-spring-marathon
cd java-starship-spring-marathon
idea .
```

The model and service layer have been built for you. We've also provided data in the `JavaStarShipService`. Your job is to build out the controller and the relevant view templates. You will not need to interact with a database, to start.

## Core Requirements

### Show StarShip

```no-highlight
As a Space Traffic Controller
I want to see more detail about an individual starship
So that I can manage its interstellar flight plan
```

Acceptance Criteria:

- When I navigate to `/starships/show/<starShipId>` I am presented with the relevant starship information
- For the relevant starship, I can see the starship's name, description, and fuel capacity (in Teraliters, stored as an integer)
- There should be a link that takes me back to the index page

### List StarShips

```no-highlight
As a Space Traffic Controller
I want to see a list of StarShips
So that I can keep the spaceways clear
```

Acceptance Criteria:

- When I navigate to `/starships`, I should see the starships provided.
- For each starship, I should see their name, price, and fuel capacity.
- For each starship, there should be a link to view more details about the starship
- For each starship, there should be a link that takes me to `/starships/show/<starShipId>`

### Fuel Capacity Gauge

```no-highlight
As a Space Traffic Controller
I want to have a visual indicator of fuel capacity
So that I can easily ensure all ships can reach their destination
```

Acceptance Criteria:

- When I'm viewing a list of starships or an individual starship, I see the name in a color based on fuel capacity. Green for high capacity(>700), yellow for average (300-700),and red for low (<300).

***Note***

- We have supplied a css file for you in `src/main/resources/static/css/main.css`
- You can access this via a `<link>` in your view templates via the path `/css/main.css`
- For an extra challenge see if you can find a Font Awesome icon for each level and get it to show up on the page

### Add a New StarShip

```no-highlight
As a Space Traffic Controller
I want to add a starship
So that I can keep track of new ships entering the galaxy's spaceways
```

Acceptance Criteria:

- When I navigate to `/starships/new`, I am presented with a form to input a new starship
- I must enter the starship's name, description, and fuel capacity.
- Upon successful submission I should be redirected to the `show page` for that starship.

### There Must Be a Better Way!

```no-highlight
As a Space Traffic Controller
I want to have a starship database
So that I have a reliable source of truth
```

Acceptance Criteria:

- Update your `pom.xml` and `application.properties` to use Spring Data and Postgres
- Create a `starships` table
- Create a migration for your `starships` table
- Update your StarShip model with the appropriate annotations
- Create a repository
- Transition the starting data into a seeder file
- Update your form endpoint to reflect these changes as needed
- When I visit `/starships/show/<starShipId>` I should see all of the relevant `StarShip`'s information
