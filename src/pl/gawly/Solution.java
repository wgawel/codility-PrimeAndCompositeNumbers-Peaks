package pl.gawly;

public class Solution {

    public int solution(int[] A) {
        if (A.length <= 2) {
            return 0;
        }

        int[] peaks = new int[A.length];
        for (int j = 1; j < A.length-1; j++) {
            if (A[j-1] < A[j] && A[j+1] < A[j]) {
                peaks[j] = peaks[j-1] + 1;
            } else {
                peaks[j] = peaks[j-1];
            }
        }
        peaks[A.length-1] = peaks[A.length-2];

        int maxBlocks = 0;

        int i;
        for (i = 1; i * i < A.length; i++) {
            if (A.length % i == 0) {
                int lastPeaks = 0;
                boolean eachHasPeak = true;
                for (int j = i - 1; j < peaks.length; j = j + i) {
                    if (peaks[j] == lastPeaks) {
                        eachHasPeak = false;
                        break;
                    } else {
                        lastPeaks = peaks[j];
                    }
                }
                if (eachHasPeak) {
                    maxBlocks = Math.max(maxBlocks, A.length/i);
                }
                // sym div

                lastPeaks = 0;
                eachHasPeak = true;
                int k = A.length / i;
                for (int j = k - 1; j < peaks.length; j = j + k) {
                    if (peaks[j] == lastPeaks) {
                        eachHasPeak = false;
                        break;
                    } else {
                        lastPeaks = peaks[j];
                    }
                }
                if (eachHasPeak) {
                    maxBlocks = Math.max(maxBlocks, A.length/k);
                }
            }
        }
        if (i * i == A.length) {
            int lastPeaks = 0;
            boolean eachHasPeak = true;
            for (int j = i - 1; j < peaks.length; j = j + i) {
                if (peaks[j] == lastPeaks) {
                    eachHasPeak = false;
                    break;
                } else {
                    lastPeaks = peaks[j];
                }
            }
            if (eachHasPeak) {
                maxBlocks = Math.max(maxBlocks, A.length/i);
            }
        }

        return maxBlocks;
    }
}
