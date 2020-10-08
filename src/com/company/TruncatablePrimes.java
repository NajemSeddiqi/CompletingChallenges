package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TruncatablePrimes extends Challenge {
    enum Side {NONE, LEFT, RIGHT, BOTH}

    private ArrayList<Integer> leftSide = new ArrayList<>();
    private ArrayList<Integer> rightSide = new ArrayList<>();

    Side truncatable(int n) {
        if (String.valueOf(n).contains("0")) return Side.NONE;
        return getSide(checkPath(n));
    }


    private Side getSide(int n) {
        switch (n) {
            case 2:
                return Side.BOTH;
            case 1:
                return Side.LEFT;
            case 3:
                return Side.RIGHT;
            case -1:
                return Side.NONE;
        }
        return Side.NONE;
    }

    private int checkPath(int n) {
        var map = new HashMap<Integer, ArrayList<Integer>>();
        var sb = new StringBuilder(String.valueOf(n));

        leftSide.add(n);
        rightSide.add(n);

        if (String.valueOf(n).length() == 1) return getSideForShortNumber(n, map);

        coverBothSides(n, sb);

        boolean t1 = traverse(map, leftSide);
        map.clear();
        boolean t2 = traverse(map, rightSide);

        return t1 && t2 ? 2 : t1 ? 1 : t2 ? 3 : -1;
    }

    private void coverBothSides(int n, StringBuilder sb) {
        pathLeft(sb);

        sb.delete(0, sb.length());
        sb.append(n);

        pathRight(sb);
    }

    private void pathRight(StringBuilder sb) {
        for (var i = sb.length() - 1; i > 0; i--) {
            sb.deleteCharAt(i);
            rightSide.add(Integer.parseInt(sb.toString()));
        }
    }

    private void pathLeft(StringBuilder sb) {
        for (var i = 0; i < sb.length(); i++) {
            sb.deleteCharAt(0);
            leftSide.add(Integer.parseInt(sb.toString()));

            if (sb.length() == 2)
                leftSide.add(Integer.parseInt(String.valueOf(sb.charAt(1))));
        }
    }

    private int getSideForShortNumber(int n, HashMap<Integer, ArrayList<Integer>> map) {
        boolean c = traverse(map, new ArrayList<>() {{
            add(n);
        }});

        return c ? 2 : -1;
    }

    private boolean traverse(HashMap<Integer, ArrayList<Integer>> map, ArrayList<Integer> p) {
        ArrayList<Integer> a;
        for (int x : p) {
            a = new ArrayList<>();
            for (int i = 1; i < x; i++)
                if (x % i == 0) {
                    a.add(i);
                    if (i != x / i)
                        a.add(x / i);
                }
            map.put(x, a);
        }
        return getCountOfFactors(map) == map.size();
    }

    private int getCountOfFactors(HashMap<Integer, ArrayList<Integer>> map) {
        int count = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            if (e.getValue().size() == 2)
                count++;

            if (e.getKey() == 4)
                count--;
        }
        return count;
    }


    @Override
    public void show() {
        System.out.println(truncatable(7331));
//        System.out.println(truncatable(9137));
//        System.out.println(truncatable(5939));
//        System.out.println(truncatable(317));
//        System.out.println(truncatable(139));
//        System.out.println(truncatable(103));
    }
}



