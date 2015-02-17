import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

import from.hyeoncheol.Parser;
import from.hyeoncheol.Solver;

/**
 * solution that maximum number of walls that  we need to climb to get one to another place
 * input: # of circle walls, list of x/y/radius
 */
class FortressParser extends Parser<Integer[]> {
	public FortressParser(InputStream in) {
		super(in);
	}

	protected List<Integer[]> parseCase() {
		int walls = scan.nextInt();
		List<Integer[]> list = new ArrayList<Integer[]>(walls);
		for (int i = 0; i < walls; i++) {
			// x, y, radius
			Integer[] wall = new Integer[3];
			wall[0] = scan.nextInt();
			wall[1] = scan.nextInt();
			wall[2] = scan.nextInt();
			list.add(wall);
		}
		return list;
	}
}

class FortressSolver extends Solver<Integer[]> {
	class Castle {
		class Wall {
			public int x, y, radius;
			public List<Wall> children = new ArrayList<Wall>();

			public Wall(int x, int y, int radius) {
				this.x = x;
				this.y = y;
				this.radius = radius;
			}

			public boolean contain(Wall wall) {
				double dist = Math.hypot(x - wall.x, y - wall.y);
				return (radius >= dist + wall.radius);
			}
		}

		Wall root;

		public Castle(int x, int y, int radius) {
			root = new Wall(x, y, radius);
		}

		public void putWall(int x, int y, int radius) {
			Wall wall = new Wall(x, y, radius);
			put(root, wall);
		}

		private void put(Wall parent, Wall newWall) {
			for (int i = 0; i < parent.children.size(); i++) {	
				Wall child = parent.children.get(i);
				if (child.contain(newWall)) {
					put(child, newWall);
					return;
				} else if (newWall.contain(child)) {
					newWall.children.add(child);
					parent.children.set(i, newWall);
					return;
				}	
			}
			parent.children.add(newWall);
		}

		/** return maximum # of walls which must be climbed over
		 * to get to some place
		 */
		public int climbWalls() {
			List<Integer> heights = new ArrayList<Integer>(root.children.size());
			for (int i = 0; i < root.children.size(); i++) {
				heights.add(height(root.children.get(i)));
			}
			Collections.sort(heights, Collections.reverseOrder());
			if (heights.size() > 1) 
				return heights.get(0) + heights.get(1) + 2;
			else
				return heights.get(0) + 1;
		}

		private int height(Wall wall) {
			int longest = 0;

			if (wall.children.size() == 0) {
				return 0;
			} else {
				for (int i = 0; i < wall.children.size(); i++) {
					int h = height(wall.children.get(i));
					if (h > longest)
						longest = h;
				}
				return longest + 1;
			}
		}
	}

	public FortressSolver(PrintStream out) {
		super(out);
	}

	public void solve(List<Integer[]> list) {
		Integer[] wall = list.get(0);
		Castle castle = new Castle(wall[0], wall[1], wall[2]);
		for (int i = 1; i < list.size(); i++) {	
			wall = list.get(i);
			castle.putWall(wall[0], wall[1], wall[2]);
		}
		out.println(castle.climbWalls());
	}

	public static void main(String[] args) {
		FortressParser parser = new FortressParser(System.in);
		parser.solve(new FortressSolver(System.out));
	}
}
