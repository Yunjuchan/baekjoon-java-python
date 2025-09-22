import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {

    public static class Card {
        int id;
        String type;
        int n;

        public Card(int id, String type, int n) {
            this.id = id;
            this.type = type;
            this.n = n;
        }
    }

    public static class Player {

        int playerId;
        Set<Integer> cardSet;
        Card currentCard;

        public Player(int playerId) {
            this.playerId = playerId;
            cardSet = new HashSet<>();
            currentCard = null;
        }

        public Card getCurrentCard() {
            return currentCard;
        }

        public void setCurrentCard(Card currentCard) {
            this.currentCard = currentCard;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] turn = new int[T];
        Player[] players = new Player[N + 1];
        Map<Integer, Integer> cardMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            turn[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            players[i] = new Player(i);
        }

        int t = 0;
        int tt = 0;
        while (t < T && tt < T) {
            int playerId = turn[t];
            if (players[playerId].currentCard == null) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                String type = st.nextToken();
                int n;
                if (type.equals("next")) {
                    n = 0;
                } else {
                    n = Integer.parseInt(st.nextToken());
                }

                Card card = new Card(id, type, n);

                if (type.equals("next")) {
                    sb.append(card.id).append("\n");
                } else if (type.equals("release")) {
                    int p = cardMap.getOrDefault(card.n, -1);
                    if (p != -1) {
                        players[p].cardSet.remove(card.n);
                        cardMap.remove(card.n);
                    }
                    sb.append(card.id).append("\n");
                } else {
                    int p = cardMap.getOrDefault(card.n, -1);
                    if (p == -1) {
                        players[playerId].cardSet.add(card.n);
                        cardMap.put(card.n, playerId);
                    } else {
                        players[playerId].currentCard = card;
                        tt--;
                    }
                    sb.append(card.id).append("\n");
                }
            } else {
                Card card = players[playerId].currentCard;
                int p = cardMap.getOrDefault(card.n, -1);
                if (p == -1) {
                    players[playerId].cardSet.add(card.n);
                    cardMap.put(card.n, playerId);
                    players[playerId].currentCard = null;
                } else {
                    tt--;
                }
                sb.append(card.id).append("\n");
            }
            t++;
            tt++;
        }

        System.out.println(sb);
    }
}