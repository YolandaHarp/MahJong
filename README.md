# MahJong
## Required Configuration

### JavaFX Environment Configuration
**Before running the game, please ensure that the necessary JavaFX environment is configured.**

### JUnit Environment Configuration
**Before running the tests, please ensure that the necessary JUnit environment is configured.**

# Introduction

Mahjong is a four-person game that originated in China. It is a form of entertainment generally made of bamboo, bone, or plastic, consisting of small rectangular pieces engraved with patterns or words. The game contains 136 tiles. The way mahjong is played varies depending on the region and cultural background.

## Tile Types

Mahjong tiles are divided into Dot, Bamboo, and Character suits, each suit containing numbers 1 to 9, with four of each tile. Additionally, there are special Honor tiles, such as East, South, West, and North tiles.

## The Goal of the Game

The player's goal is to form the tiles in their hand into specific tile types, such as pairs (two identical tiles), triplets (three identical tiles), quads (four identical tiles), and sequences (three consecutive tiles).

## Winning Rules

When playing, players need to have a pair of tiles (pairs) and three sets of sequences or triplets. However, there are other special ways to win, such as forming 7 pairs of identical tiles and other traditional combinations that may require certain lucky values.

## Special Rules

- **Chow**: If the last tile played by a player completes a sequence with two tiles in the next player's hand, they can declare Chow.
- **Pong**: If another player plays a tile and a player has two identical tiles in their hand that complete a triplet, they can declare Pong.
- **Kong**: Kongs are divided into exposed Kong and concealed Kong. If a player has three identical tiles in their hand and another player plays the fourth tile, they can declare an exposed Kong. If a player has three identical tiles in their hand and draws the fourth tile themselves, they can declare a concealed Kong.
- **Ready Hand**: When a player has all their tiles organized into useful combinations and needs only one more tile to complete a winning hand, they are in the ready hand stage.
- **Winning from Others**: A player can win if another player plays the exact tile they need to complete their hand.

## Version

The version of this project is the **Beijing Version**, which has some different rules compared to other versions.

### Tiles Differences

In the Beijing Version, the tiles named "Bonus" do not exist. The total number of tiles in one game is 136.

### Joker

In each game, after all four players have drawn their cards, the first card will be placed face-up to indicate the Joker, which is the next tile in sequence after the face-up card. For example, if the face-up tile is Bamboo 2, the Joker will be Bamboo 3. Similarly, the order for "Honors" is "East Wind," "South Wind," "West Wind," "North Wind," "Red Dragon," "Green Dragon," and "White Dragon." The Joker can represent any type of tile but cannot be used in Kongs, neither exposed nor concealed.

### Rules Differences

The rules to win a game have some differences. A person can wait for the one necessary tile to win only if the player did not perform any actions like "Chow," "Pong," or "Kong," meaning the player keeps 13 tiles in their hand without showing any tiles face-up to other players. If a player performs any actions, they can only win by drawing a tile themselves. There are no limits on the number of actions a player can perform.

### Remind
After entering the game, click the <> at the bottom of the screen to switch languages.
The top right corner provides an introduction to the game operations.
