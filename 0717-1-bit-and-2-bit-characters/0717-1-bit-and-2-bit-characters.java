class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        return (bits[bits.length - 1] ==  0 && (bits.length & 1) == 1);
    }
}