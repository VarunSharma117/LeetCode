import java.util.LinkedList;
import java.util.Queue;

/*
	Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
		0: Empty cell
		1: Cells have fresh oranges
		2: Cells have rotten oranges
	Determine what is the minimum time required so that all the oranges become rotten.
	A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right).
	If it is impossible to rot every orange then simply return -1.
*/
public class RotOranges {

    public final static int R = 3;
    public final static int C = 5;


    // structure for storing coordinates of the cell
    static class Ele
    {
        int x = 0;
        int y = 0;
        Ele(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static int xarr[] = new int[] {1, -1, 0, 0};
    public static int yarr[] = new int[] {0, 0, 1, -1};


    // function to check whether a cell is valid / invalid
    static boolean isValid(int i, int j)
    {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }


    // Function to check whether the cell is delimiter
    // which is (-1, -1)
    static boolean isDelim(Ele temp)
    {
        return (temp.x == -1 && temp.y == -1);
    }

    // Function to check whether there is still a fresh
    // orange remaining
    static boolean checkAll(int arr[][])
    {
        for (int i=0; i<R; i++)
            for (int j=0; j<C; j++)
                if (arr[i][j] == 1)
                    return true;
        return false;
    }

    static int rotOranges(int[][] arr) {
        int ans = 0;
        Queue<Ele> Q = new LinkedList<>();
        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++)
                if(arr[i][j] == 2)
                    Q.add(new Ele(i, j));
        Q.add(new Ele(-1, -1));

        while(!Q.isEmpty()) {
            Ele e = Q.poll();
            if(isDelim(e) && !Q.isEmpty()) {
                Q.add(new Ele(-1, -1));
                ans++;
            }
            for(int i = 0; i < 4; i++) {
                int x = e.x + xarr[i];
                int y = e.y + yarr[i];
                if(isValid(x, y) && arr[x][y] == 1) {
                    arr[x][y] = 2;
                    Q.add(new Ele(x, y));
                }
            }

        }
        if(checkAll(arr))
            return -1;
        else
            return ans;
    }

    public static void main(String[] args) {

        int arr[][] = { {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        int ans = rotOranges(arr);
        if(ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);
    }
}
