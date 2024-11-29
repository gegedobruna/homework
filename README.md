# Game of Thrones Regions Repository

## Overview
The **Regions Repository** is a Java-based project inspired by the world of *Game of Thrones*. It models the Seven Kingdoms and beyond, allowing you to explore regions, their ruling houses, and settlements. From the icy expanses of the North to the bustling cities of Essos, you can query, sort, and analyze data about the lands and their rulers.

---

## Features
- Discover the **largest region** by area.
- Sort regions by size, house, and name to see how the kingdoms stack up.
- Explore which **houses rule which continents**.
- Map **settlements and sigils** by continent.
- Visualize the intricate relationships between **continents, houses, and regions**.

---

## Structure
- **`base` Package**: Core repository and query framework.
- **`regions` Package**: Houses the main `Regions` class and its subcomponents:
  - **Regions**: Represents the Seven Kingdoms and beyond.
  - **Settlements**: Cities like Winterfell or Meereen.
  - **Continents**: Includes Westeros, Essos, and others.
  - **RegionsRepo**: Repository for storing and querying region data.
- **Testing**: Run `TestQueriesRegions` for sample outputs.

---

## Example Query Output
```text
//////////////////////////////////////////////////////////////
Largest region:
The North (Area: 100,000 square miles)
//////////////////////////////////////////////////////////////
Regions sorted by size, house, and name:
1. Dorne (House Martell)
2. The North (House Stark)
3. The Reach (House Tyrell)
//////////////////////////////////////////////////////////////
Regions in Westeros:
The North, The Vale, The Stormlands
//////////////////////////////////////////////////////////////
```

---

## Getting Started
1. Clone the repository.
2. Ensure Java is installed.
3. Run `TestQueriesRegions` to explore the world of Westeros and beyond.

---

## Future Enhancements
- Add regions from **Valyria** or the **Shadow Lands**.
- Visual maps of the continents and their sigils.
- Advanced filters to dive deeper into *Game of Thrones* lore.

---

The world is vast, and the game is on. Choose your house, and let the exploration begin.
