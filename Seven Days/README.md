## Seven Days

**1998\. A small town in Japan.**

![TV with a silhouette of a woman with long black hair](https://ucarecdn.com/9ecc0495-a1fc-455f-8b3d-4a0709a57f23/)

A mysterious videotape has appeared at a local video rental store. Its contents are disturbing: a dark well, strange figures, and a girl with long black hair covering her face.

The legend says that anyone who watches the tape will die in seven days.

But the curse has found a new way to spread.

The rental store belongs to a network of video stores that exchange tapes every evening. Somehow, the cursed tape has begun making copies of itself.

At the beginning, there is exactly **one cursed tape in store 1**.

Every evening, each cursed tape produces **one new copy for every outgoing delivery route** from its current store. The original tape stays where it is, while the new copies arrive at their destinations. Newly created copies never move again, but starting from the following evening, they produce copies of their own, just like the original.

The process continues for exactly **seven evenings**.

Your dataset begins with a line containing three space-separated integers, `N`, `M`, and `X`, representing the number of video stores, the number of directed delivery routes, and the store you need to investigate. Stores are numbered from 1 to `N`.

Each of the following `M` lines contains two integers, `a b`, indicating that store `a` has a delivery route to store `b`.

**Your answer should be the number of cursed tapes in store** `X` **after the seventh evening, submitted as a single integer.**

For example, consider a network of three stores with the following routes:

```
1 2
2 3
1 3
```

If the process lasted only two evenings:

- At the beginning, store 1 has one tape: `[1, 0, 0]`.
- After the first evening, the tape in store 1 sends copies to stores 2 and 3: `[1, 1, 1]`.
- After the second evening, the tape in store 1 again sends copies to stores 2 and 3, and the tape in store 2 sends a copy to store 3: `[1, 2, 3]`.

So store 3 would contain **3 tapes**.

*Hey, isn't your phone ringing right now?*