
    // meaghan.kjelland@redfin.com

    package CodingKata;

    import java.util.HashMap;
    import java.util.Map;

    public class MasterMind {
        public static class Result {
            public int weakCount;
            public int strongCount;

            Result(int weakCount, int strongCount) {
                this.weakCount = weakCount;
                this.strongCount = strongCount;
            }
        }

        public static Result printMatches(int[] secretCode, int[] guess) {
            if (secretCode == null) {
                return null;
            }
            if (guess == null) {
                return null;
            }
            if (guess.length != secretCode.length) {
                return null;
            }

            int weakCount = 0;
            int strongCount = 0;

            // count strong matches
            for(int i=0; i<secretCode.length; i++) {
                if (secretCode[i] == guess[i]) {
                    strongCount++;
                }
            }

            // frequency count our secret code
            Map<Integer, Integer> count = new HashMap<Integer,Integer>();
            for (int i=0; i<secretCode.length; i++) {
                int digit = secretCode[i];

                if (count.containsKey(digit)) {
                    count.put(digit, count.get(digit) + 1);
                } else {
                    count.put(digit, 1);
                }
            }

            // count weak matches
            for (int j=0; j<guess.length; j++) {
                int digit = guess[j];

                if (count.containsKey(digit)) {
                    weakCount++;

                    // decrement frequency count accordingly
                    int currCount = count.get(digit);
                    if (currCount == 1) {
                        count.remove(digit);
                    } else {
                        count.put(digit, currCount - 1);
                    }
                }
            }

            weakCount -= strongCount;

            return new Result(weakCount, strongCount);
        }
    }
