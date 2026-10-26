## The Night He Came Home

***October 31, 1978. Haddonfield, Illinois.***

![Nighttime empty street with police car and a shadow figure on the horizon](https://ucarecdn.com/cddd6edc-f75b-4f68-9e8f-cba0244b4a86/)

The streets were quiet. Jack-o'-lanterns flickered on empty porches, and the last trick-or-treaters had already gone home. You were about to finish your shift at the local police station when the phone rang.

"There's a man outside my house," a frightened voice whispered. "He's wearing a white mask. He's just... standing there."

Before you could respond, the caller hung up. Then another call came in. And another.

Soon, the station was flooded with reports of a mysterious figure wandering the streets of Haddonfield. Some witnesses claimed to have seen him at opposite ends of town within minutes.

Your colleague dropped a stack of reports onto your desk.

"There's no way all these sightings are real. Can you figure out which ones are impossible?"

Fortunately, all the reported sightings took place along a single street with consecutively numbered houses. You also know that the mysterious figure travels on foot and **cannot move more than one house per minute**.

Your dataset contains chronologically ordered reports, each consisting of two space-separated integers: `timestamp` (minutes since midnight) and `house_number`. All reports are guaranteed to have unique timestamps.

The first report is always considered reliable. For every subsequent report, determine whether the figure could have reached the reported house from the **last accepted sighting** in the time available. If not, reject it and continue checking against the last accepted sighting.

**Your answer should be the total number of rejected reports, submitted as a single integer.**

For example, consider the following reports:

```
0 10
3 12
5 20 # Passing 8 houses in 2 minutes is impossible
7 15
10 17
```

The first two sightings are accepted: moving from house 10 to house 12 in 3 minutes is possible. The third report is rejected because reaching house 20 in just 2 minutes is impossible. The fourth and fifth reports are accepted, since the figure could reach houses 15 and 17 from the last accepted locations.

Therefore, the correct answer for this example is `1`.

> Note that the figure can move both up and down the street.

And whatever you do, ***DO NOT*** look out the window.
