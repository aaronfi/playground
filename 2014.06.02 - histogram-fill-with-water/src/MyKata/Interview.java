package MyKata;

public class Interview {

    public static int FillHistogramWithWater(int[] h) {
        int count = 0;

        int tallestKnownHeightFromLeft = -1;
        int tallestKnownHeightFromRight = -1;

        int candidateSum = 0;
        for(int i=0; i<h.length; i++) {
            if (h[i] >= tallestKnownHeightFromLeft) {
                count += candidateSum;
                candidateSum = 0;
                tallestKnownHeightFromLeft = h[i];
            } else {
                candidateSum += tallestKnownHeightFromLeft - h[i];
            }
        }

        candidateSum = 0;
        for(int i=h.length-1; i >= 0; i--) {
            if (h[i] >= tallestKnownHeightFromRight) {
                count += candidateSum;
                candidateSum = 0;
                tallestKnownHeightFromRight = h[i];
            } else {
                candidateSum += tallestKnownHeightFromRight - h[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {        
    }
}
