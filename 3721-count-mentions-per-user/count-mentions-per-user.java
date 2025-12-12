class Solution {
    public int[] countMentions(int n, List<List<String>> events) {
        // sort by (timestamp asc, OFFLINE before MESSAGE at same timestamp)
        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2)
                return Integer.compare(t1, t2);

            // same timestamp: OFFLINE before MESSAGE
            String type1 = a.get(0), type2 = b.get(0);
            if (type1.equals(type2))
                return 0;
            if (type1.equals("OFFLINE"))
                return -1;
            return 1;
        });

        int[] mentions = new int[n];
        boolean[] online = new boolean[n];
        int[] offlineUntil = new int[n];
        Arrays.fill(online, true);

        for (List<String> event : events) {
            String type = event.get(0);
            int timeStamp = Integer.parseInt(event.get(1));

            // Bring users back online if their offline time expired BEFORE handling this event
            for (int i = 0; i < n; i++) {
                if (!online[i] && timeStamp >= offlineUntil[i]) {
                    online[i] = true;
                }
            }

            if (type.equals("OFFLINE")) {
                int id = Integer.parseInt(event.get(2));
                online[id] = false;
                offlineUntil[id] = timeStamp + 60;
                continue;
            }

            // MESSAGE
            String msg = event.get(2);
            String[] tokens = msg.split(" ");

            for (String token : tokens) {
                if (token.equals("ALL")) {
                    for (int i = 0; i < n; i++)
                        mentions[i]++;
                } else if (token.equals("HERE")) {
                    for (int i = 0; i < n; i++)
                        if (online[i])
                            mentions[i]++;
                } else if (token.startsWith("id")) {
                    int id = Integer.parseInt(token.substring(2));
                    mentions[id]++;
                }
            }
        }

        return mentions;
    }
}
