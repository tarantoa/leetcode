import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

class Solution {

    private static enum GridDirection {
        RIGHT {
            @Override
            Solution.GridPosition from(final Solution.GridPosition currentPosition) {
                return new Solution.GridPosition(currentPosition.row, currentPosition.col + 1);
            }
        },
        DOWN {
            @Override
            Solution.GridPosition from(final Solution.GridPosition currentPosition) {
                return new Solution.GridPosition(currentPosition.row + 1, currentPosition.col);
            }
        },
        LEFT {
            @Override
            Solution.GridPosition from(final Solution.GridPosition currentPositon) {
                return new Solution.GridPosition(currentPositon.row, currentPositon.col - 1);
            }
        },
        UP {
            @Override
            Solution.GridPosition from (final Solution.GridPosition currentPosition) {
                return new Solution.GridPosition(currentPosition.row - 1, currentPosition.col);
            }
        };

        abstract Solution.GridPosition from(final GridPosition position);
    }

    private static final GridDirection[] GRID_DIRECTIONS = new GridDirection[] {
        GridDirection.RIGHT,
        GridDirection.DOWN,
        GridDirection.LEFT,
        GridDirection.UP
    };
        
    private static boolean positionValid(char[][] grid, GridPosition position) {
        if (position.row >= 0 && position.row < grid.length &&
            position.col >= 0 && position.col < grid[position.row].length &&
            grid[position.row][position.col] == '1') {
                return true;
            }

        return false;
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        final int gridCells = grid.length * grid[0].length;
        return IntStream.range(0, gridCells)
            .mapToObj(index -> GridPosition.fromLinearIndex(index, grid.length, grid[0].length))
            .reduce(0, (acc, currentPosition) -> {
                if (positionValid(grid, currentPosition)) {                    
                    dfs(grid, currentPosition);
                    return acc + 1;
                }

                return acc;
            }, Integer::sum);
    }

    private static void dfs(char[][] grid, GridPosition startingPosition) {
        Stack<GridPosition> stack = new Stack<>();
        stack.push(startingPosition);

        while (!stack.isEmpty()) {
            GridPosition currentPosition = stack.pop(); 
            pushNeighbors(grid, currentPosition, stack); 
            grid[currentPosition.row][currentPosition.col] = '0';
        }
    }

    private static void pushNeighbors(char[][] grid, GridPosition currentPosition, Stack<GridPosition> stack) {
        Arrays.stream(GRID_DIRECTIONS)
            .map(currentDirection -> currentDirection.from(currentPosition))
            .filter(newPosition -> positionValid(grid, newPosition))
            .forEach(stack::push);
    }

    private static class GridPosition {
        public int row;
        public int col;

        private GridPosition(final int row, final int col) {
            this.row = row;
            this.col = col;
        }

        private static GridPosition fromLinearIndex(int currentIndex, final int rows, final int cols) {
            int col = currentIndex % cols;
            int row = (currentIndex - col) / cols;
            return new GridPosition(row, col);
        }

        public boolean equals(Object other) {
            if (other == null || other.getClass() != this.getClass()) {
                return false;
            }

            return this.row == ((GridPosition) other).row && 
                this.col == ((GridPosition) other).col;
        }
    }
}