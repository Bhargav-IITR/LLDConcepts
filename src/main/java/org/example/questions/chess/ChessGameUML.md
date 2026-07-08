# Chess Game - Class Diagram (Simplified)

```
                              +----------------+
                              |      Game      |
                              +----------------+
                              | - board        |
                              | - player1      |
                              | - player2      |
                              | - currentTurn  |
                              | - moveHistory  |
                              | - status       |
                              +----------------+
                                 |      |      \
                 has-a (1) *-----+      |       \ has-a (many)
                                 |      |        \
                                 |      |         *
                                 |      |      +--------+
                                 |      |      |  Move  |
                                 |      |      +--------+
                                 |      |
                     has-a (2) o--      o-- has-a (Player)
                                 |
                          +--------------+
                          |    Player    |
                          +--------------+
                          | - name       |
                          | - side       |
                          +--------------+
                                 |
                                 |
                                 v
                          +--------------+
                          | PieceColor   |
                          +--------------+


                              |
                              |
                              v
                       +---------------+
                       |     Board     |
                       +---------------+
                       | - cells[][]   |
                       +---------------+
                               |
                        contains (*)
                               |
                               v
                        +--------------+
                        |     Cell     |
                        +--------------+
                        | - piece      |
                        | - position   |
                        +--------------+
                          |         |
                  contains|         |contains
                          |         |
                          v         v
                   +------------+ +-------------+
                   |   Piece    | |  Position   |
                   | <<abstract>>| +-------------+
                   +------------+
                   | type       |
                   | color      |
                   +------------+
                    /    |    \
                   /     |     \
                  /      |      \
                 v       v       v
             +------+ +------+ +------+
             | King | |Queen | |Rook  |
             +------+ +------+ +------+
                 |       |        |
                 |       |        |
             +--------+ +--------+ +--------+
             |Bishop | |Knight | | Pawn   |
             +--------+ +--------+ +--------+

Piece -----------------------> PieceType
Piece -----------------------> PieceColor

Move ------------------------> Player
Move ------------------------> Cell (start)
Move ------------------------> Cell (end)
Move ------------------------> Piece (moved)
Move ------------------------> Piece (captured)

Game ------------------------> GameStatus
```

---

## Legend

```
A -------> B     Association / Uses

A o------ B      Aggregation (has-a)

A *------ B      Composition (strong has-a)

A <|------ B     Inheritance (is-a)
```

### Inheritance

```
                  +----------------+
                  |     Piece      |
                  |  <<abstract>>  |
                  +----------------+
                     ^   ^   ^   ^
                     |   |   |   |
       +------+------+---+---+------+
       |      |      |       |      |
    +------+ +------+ +------+ +------+
    | King | |Queen | |Rook | |Pawn |
    +------+ +------+ +------+ +------+
       |                 |
   +--------+      +---------+
   |Bishop |      |Knight   |
   +--------+      +---------+
```