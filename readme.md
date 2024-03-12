
Character Hit Point Access Protocol (CHPAP)


| Client Request | Server Response              | Description                                                  |
|----------------|------------------------------|--------------------------------------------------------------|
| CURRENT n      | n and the current hit points | Get the current hit points of character n                    |
| HEAL n a       | n and the new current HP     | Increases HP of character n by amount a up to max HP         |
| DAMAGE n a     | n and the new current HP     | Reduces HP of character n by amount a down to a minimum of 0 |
| RESTORE n      | n and the current (max) HP)  | Resets the HP of character n back to "full" (maxHP)          |
| INCREASE n a   | n and the new max HP         | Increases the max HP of character n by value a               |
| QUIT           | Quit the connection          |                                                              |

