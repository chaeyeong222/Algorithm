import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int target = n + 1;
        int round = 1; // 시작은 1라운드
        
        // 초기 손패
        Set<Integer> initialHand = new HashSet<>();
        for (int i = 0; i < n / 3; i++) {
            initialHand.add(cards[i]);
        }
        
        // 동전으로 가져온 카드들
        Set<Integer> coinCards = new HashSet<>();
        
        // 카드 뽑기 시작 인덱스
        int idx = n / 3;
        
        while (idx < n) {
            // 2장 뽑기
            int card1 = cards[idx];
            int card2 = cards[idx + 1];
            
            // 일단 coinCards에 넣어둠 (아직 가져가지 않음)
            coinCards.add(card1);
            coinCards.add(card2);
            
            boolean canProceed = false;
            
            // 우선순위 1: 초기 손패끼리 (동전 0개)
            for (int card : initialHand) {
                int complement = target - card;
                if (initialHand.contains(complement)) {
                    initialHand.remove(card);
                    initialHand.remove(complement);
                    canProceed = true;
                    break;
                }
            }
            
            // 우선순위 2: 초기 손패 1장 + 동전 카드 1장 (동전 1개)
            if (!canProceed && coin >= 1) {
                for (int card : initialHand) {
                    int complement = target - card;
                    if (coinCards.contains(complement)) {
                        initialHand.remove(card);
                        coinCards.remove(complement);
                        coin--;
                        canProceed = true;
                        break;
                    }
                }
            }
            
            // 우선순위 3: 동전 카드 2장 (동전 2개)
            if (!canProceed && coin >= 2) {
                for (int card : coinCards) {
                    int complement = target - card;
                    if (coinCards.contains(complement) && card != complement) {
                        coinCards.remove(card);
                        coinCards.remove(complement);
                        coin -= 2;
                        canProceed = true;
                        break;
                    }
                }
            }
            
            if (!canProceed) {
                break; // 더 이상 진행 불가
            }
            
            round++;
            idx += 2;
        }
        
        return round;
    }}