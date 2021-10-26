import java.util.*;

public class CollectEnergy {
  public static int getRich(long initialEnergy, List<Integer> energy, List<Integer> coins) {
    int en = (int) initialEnergy;
    int[][] dp = new int[en+1][energy.size()+1];
    for(int i=0; i<en+1; i++){
      Arrays.fill(dp[i], -1);
    }
    return getRes(en, 0, dp, energy, coins);
  }

  public static int getRes(int leftEnergy, int index, int[][] dp, List<Integer> energy, List<Integer> coins){
    int n = energy.size();
    if(leftEnergy <0 || index >= n) return 0;
    System.out.println(leftEnergy+" "+index);
    if(dp[leftEnergy][index] != -1) return dp[leftEnergy][index];
    if(leftEnergy ==0 ) return getRes(leftEnergy-1+energy.get(index), index+1, dp, energy, coins);
    int collectEnergy = getRes(leftEnergy-1+energy.get(index), index+1, dp, energy, coins);
    int collectCoin = getRes(leftEnergy - 1, index+1, dp, energy, coins) + coins.get(index);
    int res = Math.max(collectCoin, collectEnergy);
    System.out.println("index "+index+"   "+"collectEnergy "+collectEnergy+"  collectCoin"+collectCoin+" leftEnergy "+leftEnergy+" energyand coind"+energy.get(index)+" "+coins.get(index));
    dp[leftEnergy][index] = res;
    return res;
  }

  public static void main(String[] args) {
   LinkedList energy =  new LinkedList<Integer>();
   energy.addLast(1);
    energy.addLast(5);
    energy.addLast(3);
    energy.addLast(3);
    energy.addLast(1);
    LinkedList<Integer> coins = new LinkedList<>();
    coins.addLast(3);
    coins.addLast(23);
    coins.addLast(9);
    coins.addLast(2);
    coins.addLast(2);
    getRich(1,energy,coins);
  }

}
