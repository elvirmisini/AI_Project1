package SocialGolferProblem;
import java.util.*;

import static SocialGolferProblem.Utils.*;

public class SocialGolferProblem {
    static int[][] state = new int[32][32];
    static int[] players = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
            22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    static int numberOfPlayersInAGroup = 4;
    static int numberOfGroups = 8;
    static List<List<Integer>> notAllowedGroupCombinations = new ArrayList<>();

    public static boolean isAddingPlayerToGroupValid(List<Integer> group, int player) {
        for (int i = 0; i < group.size(); i++) {
            if (state[group.get(i)][player] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPlayerNotUsedInCurrentWeek(List<List<Integer>> week, int player) {
        for (int i = 0; i < week.size(); i++) {
            if (week.get(i).contains(player))
                return false;
        }
        return true;
    }


    public static List<List<Integer>> generateWeek() throws StackOverflowError {
        List<List<Integer>> week = new ArrayList<>();
        List<Integer> group = new ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players.length; j++) {
                if (i < 32 && players[i] != players[j]) {
                    if (group.size() == 0 && isPlayerNotUsedInCurrentWeek(week, players[i])) {
                        group.add(players[i]);
                    }
                    if (!group.contains(players[j]) &&
                            isAddingPlayerToGroupValid(group, players[j]) &&
                            isPlayerNotUsedInCurrentWeek(week, players[j])) {
                        group.add(players[j]);
                    }
                    if (notAllowedGroupCombinations.contains(group)) {
                        week.remove(group);
                        group = new ArrayList<>();
                    }
                    if (group.size() == numberOfPlayersInAGroup) {
                        week.add(group);
                        updateState(state, group);
                        group = new ArrayList<>();
                        i++;
                        j = 0;
                    }
                }
                if (week.size() == numberOfGroups) {
                    notAllowedGroupCombinations = new ArrayList<>();
                    return week;
                }
            }
        }

        // since the week generated is wrong, we return to the previous state
        for (int i = 0; i < week.size(); i++) {
            returnToPreviousState(state, week.get(i));
        }
        notAllowedGroupCombinations.addAll(week);
        return generateWeek();
    }

    public static void main(String[] args) {
        //weekOneInitializationWithTheGivenValues(state);
        for (int i = 1; i <= 5; i++) {
            List<List<Integer>> week = generateWeek();
            printWeek(week, i);
        }

        System.out.println();
        printState(state);

        Graph graph = new Graph();
        for (int i = 0; i < 32; i++) {
            graph.addVertex(String.valueOf(i));
        }

        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                if (state[i][j] == 1 && i != j) {
                    graph.addEdge(String.valueOf(i), String.valueOf(j));
                }
            }
        }

        System.out.println(graph.printGraph());
        System.out.println("DFS: " + GraphTraversal.depthFirstTraversal(graph, String.valueOf(0)));
        System.out.println("BFS: " + GraphTraversal.breadthFirstTraversal(graph, String.valueOf(0)));
    }
}

