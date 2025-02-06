package src.main.dsa.leetcode.daily_practice_problem;

import java.util.Arrays;

/*
You are given a positive integer array skill of even length n where skill[i] denotes the skill of the ith player.
Divide the players into n / 2 teams of size 2 such that the total skill of each team is equal.

The chemistry of a team is equal to the product of the skills of the players on that team.

Return the sum of the chemistry of all the teams, or return -1 if there is no way to divide the players
into teams such that the total skill of each team is equal.



Example 1:

Input: skill = [3,2,5,1,3,4]
Output: 22
Explanation:
Divide the players into the following teams: (1, 5), (2, 4), (3, 3), where each team has a total skill of 6.
The sum of the chemistry of all the teams is: 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22.
Example 2:

Input: skill = [3,4]
Output: 12
Explanation:
The two players form a team with a total skill of 7.
The chemistry of the team is 3 * 4 = 12.
Example 3:

Input: skill = [1,1,2,3]
Output: -1
Explanation:
There is no way to divide the players into teams such that the total skill of each team is equal.


Constraints:

2 <= skill.length <= 105
skill.length is even.
1 <= skill[i] <= 1000

link : https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/?envType=daily-question&envId=2024-10-04
 */
public class Divide_Players_Into_Teams_of_Equal_Skill {

    public static void main(String[] args) {
        System.out.println(dividePlayers(new int[]{3, 2, 5, 1, 3, 4}));
    }

    public static long dividePlayers(int[] skill) {
        long chemistry = 0;
        Arrays.sort(skill);
        int start = 0;
        int end = skill.length - 1;
        while (start < skill.length / 2) {
            if (skill[start] + skill[end] == skill[start + 1] + skill[end - 1]) {
                start++;
                end--;
            } else {
                return -1;
            }
        }
        start = 0;
        end = skill.length - 1;
        while (start < end) {
            chemistry = chemistry + (long) skill[start] * skill[end];
            start++;
            end--;
        }
        return chemistry;
    }
}
