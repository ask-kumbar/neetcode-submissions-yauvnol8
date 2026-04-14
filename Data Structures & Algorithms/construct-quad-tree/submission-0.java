/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
       return constructQuad(grid, 0, 0, grid.length); 
    }

    public Node constructQuad(int[][] grid, int row, int column, int size) {

        int val = grid[row][column];
        boolean allEqual = true;
        for (int i = row; i < row + size; i++) {
            for (int j = column; j < column + size; j++) {
                if (grid[i][j] != val) {
                    allEqual = false;
                    break;
                }
            }
        }

        Node node = null;
        if (allEqual) {
            node = new Node((val == 1), true);
        }
        else {
            node = new Node((val == 1), false);
            node.topLeft = constructQuad(grid, row, column, size / 2);
            node.topRight = constructQuad(grid, row, column + size / 2, size / 2);
            node.bottomLeft = constructQuad(grid, row + size / 2, column, size / 2);
            node.bottomRight = constructQuad(grid, row + size / 2, column + size / 2, size / 2);
        }

        return node;
    }
}