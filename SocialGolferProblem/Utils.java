package SocialGolferProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
    public static void printState(int[][] state) {
        System.out.println("-------------------------------");
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static List<Integer> mergeAndSortLists(List<List<Integer>> lists) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            result.addAll(list);
        }
        Collections.sort(result);
        return result;
    }

    public static void printWeek(List<List<Integer>> week, int weekNumber) {
        System.out.println("\nGroups of week " + weekNumber);
        week.forEach(groupInWeek -> {
            System.out.print(groupInWeek + " ");
            System.out.println();
        });
    }

    public static void updateState(int[][] state, List<Integer> group) {
        for (int i = 0; i < group.size(); i++) {
            for (int j = 0; j < group.size(); j++) {
                state[group.get(i)][group.get(j)] = 1;
            }
        }
    }

    public static void updateStateToZero(int[][] state, List<Integer> group) {
        for (int i = 0; i < group.size(); i++) {
            for (int j = 0; j < group.size(); j++) {
                state[group.get(i)][group.get(j)] = 0;
            }
        }
    }

    public static void checkIfListIsGood(List<List<Integer>> week, int weekNr) {
        if (mergeAndSortLists(week).containsAll(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31))) {
            System.out.println("week " + weekNr + " is good");
        }
    }

    public static void inicializimiMeVleraTeDhena(int[][] state) {
        List<List<Integer>> week = new ArrayList<>();
        List<Integer> g1 = new ArrayList<>();
        g1.add(0);
        g1.add(1);
        g1.add(2);
        g1.add(3);
        week.add(g1);
        updateState(state, g1);
        List<Integer> g2 = new ArrayList<>();
        g2.add(4);
        g2.add(5);
        g2.add(22);
        g2.add(23);
        week.add(g2);
        updateState(state, g2);
        List<Integer> g3 = new ArrayList<>();
        g3.add(6);
        g3.add(7);
        g3.add(20);
        g3.add(21);
        week.add(g3);
        updateState(state, g3);
        List<Integer> g4 = new ArrayList<>();
        g4.add(8);
        g4.add(25);
        g4.add(26);
        g4.add(27);
        week.add(g4);
        updateState(state, g4);
        List<Integer> g5 = new ArrayList<>();
        g5.add(9);
        g5.add(10);
        g5.add(11);
        g5.add(24);
        week.add(g5);
        updateState(state, g5);
        List<Integer> g6 = new ArrayList<>();
        g6.add(12);
        g6.add(13);
        g6.add(15);
        g6.add(30);
        week.add(g6);
        updateState(state, g6);
        List<Integer> g7 = new ArrayList<>();
        g7.add(14);
        g7.add(28);
        g7.add(29);
        g7.add(31);
        week.add(g7);
        updateState(state, g7);
        List<Integer> g8 = new ArrayList<>();
        g8.add(16);
        g8.add(17);
        g8.add(18);
        g8.add(19);
        week.add(g8);
        updateState(state, g8);
        printWeek(week, 1);
        mergeAndSortLists(week);
    }

}
