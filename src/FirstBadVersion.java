
public class FirstBadVersion {

    public static int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while (low <= high){
            int mid = low + (high - low)/2;
            if(isBadVersion(mid)){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int v = firstBadVersion(2126753390);
        System.out.println(v);
    }

    private static boolean isBadVersion(int version){
        if(version >= 1702766719){
            return true;
        }
        return false;
    }
}
