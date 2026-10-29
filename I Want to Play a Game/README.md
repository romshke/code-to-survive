## I Want to Play a Game

**2004\. An abandoned industrial building.**

![Shadowy figure on TV screen watches over people in cells with timers running](https://ucarecdn.com/75ef3f1c-261d-45b8-81d8-09b188592b65/)

You wake up in a dark room. A television flickers to life, revealing a pale puppet with red spirals on its cheeks.

*"Hello. I want to play a game."*

Several people are trapped in separate rooms throughout the building. Each room holds one person and contains a deadly mechanism connected to a countdown timer.

You have found the central control panel. It allows you to disable the traps, but there is a catch: **you can only disable one trap at a time**.

Each trap has two properties:

- `duration` — the number of minutes required to disable it.
- `deadline` — the minute at which the trap activates.

All countdown timers start simultaneously at minute **0**.

You may disable the traps in any order, and you may choose to ignore some of them. Once you begin disabling a trap, you must finish before moving to another one. A person is saved only if their trap is completely disabled **at or before its deadline**.

There is not enough time to save everyone.

**Your task is to determine the maximum number of people you can save.**

## Dataset format

The first line contains a single integer, `N`, representing the number of traps.

Each of the following `N` lines contains two space-separated integers: the trap’s `duration` and its `deadline`. Traps are numbered from 1 to `N` in the order they appear.

## Example

```
5
4 5
2 6
3 7
5 9
1 8
```

One possible strategy is:

- Disable trap 2 from minute 0 to minute 2.
- Disable trap 3 from minute 2 to minute 5.
- Disable trap 5 from minute 5 to minute 6.

All three traps are disabled at or before their deadlines. It is impossible to save more than 3 people in this example: even the four shortest traps take 10 minutes in total, which is later than every deadline.

**Answer:** `3`

*Live or die. Make your choice.*