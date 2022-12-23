package SocialGolferProblem;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static void printState(int[][] state) {
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------");
    }

    public static void printWeek(List<List<Integer>> week, int weekNumber) {
        System.out.println("\nGroups of week " + weekNumber);
        for (int i = 0; i < week.size(); i++) {
            for (int j = 0; j < week.get(i).size(); j++) {
                System.out.print(week.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void updateState(int[][] state, List<Integer> group) {
        for (int i = 0; i < group.size(); i++) {
            for (int j = 0; j < group.size(); j++) {
                state[group.get(i)][group.get(j)] = 1;
            }
        }
    }

    public static void returnToPreviousState(int[][] state, List<Integer> group) {
        for (int i = 0; i < group.size(); i++) {
            for (int j = 0; j < group.size(); j++) {
                state[group.get(i)][group.get(j)] = 0;
            }
        }
    }

    public static void weekOneInitializationWithTheGivenValues(int[][] state) {
        List<List<Integer>> weekOne = new ArrayList<>();
        List<Integer> groupOne = new ArrayList<>();
        groupOne.add(0);
        groupOne.add(1);
        groupOne.add(2);
        groupOne.add(3);
        weekOne.add(groupOne);
        updateState(state, groupOne);
        List<Integer> groupTwo = new ArrayList<>();
        groupTwo.add(4);
        groupTwo.add(5);
        groupTwo.add(22);
        groupTwo.add(23);
        weekOne.add(groupTwo);
        updateState(state, groupTwo);
        List<Integer> groupThree = new ArrayList<>();
        groupThree.add(6);
        groupThree.add(7);
        groupThree.add(20);
        groupThree.add(21);
        weekOne.add(groupThree);
        updateState(state, groupThree);
        List<Integer> groupFour = new ArrayList<>();
        groupFour.add(8);
        groupFour.add(25);
        groupFour.add(26);
        groupFour.add(27);
        weekOne.add(groupFour);
        updateState(state, groupFour);
        List<Integer> groupFive = new ArrayList<>();
        groupFive.add(9);
        groupFive.add(10);
        groupFive.add(11);
        groupFive.add(24);
        weekOne.add(groupFive);
        updateState(state, groupFive);
        List<Integer> groupSix = new ArrayList<>();
        groupSix.add(12);
        groupSix.add(13);
        groupSix.add(15);
        groupSix.add(30);
        weekOne.add(groupSix);
        updateState(state, groupSix);
        List<Integer> groupSeven = new ArrayList<>();
        groupSeven.add(14);
        groupSeven.add(28);
        groupSeven.add(29);
        groupSeven.add(31);
        weekOne.add(groupSeven);
        updateState(state, groupSeven);
        List<Integer> groupEight = new ArrayList<>();
        groupEight.add(16);
        groupEight.add(17);
        groupEight.add(18);
        groupEight.add(19);
        weekOne.add(groupEight);
        updateState(state, groupEight);
        printWeek(weekOne, 1);
    }

}
