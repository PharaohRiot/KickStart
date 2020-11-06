Google Kick Start Round A: Workout
tests
 
3
5 2
10 13 15 16 17
5 6
9 10 20 26 30
8 3
1 2 3 4 5 6 7 10


Algorithm I came up with to solve the problem

9 10 20 26 30 1  2  3  4  5   6  7
9 10 12 14 16 18 20 22 24 26 28 30  12   k = 2;  wrong
9 10 13 16 19 20 23 26 29 30        10   k = 3;  wrong


9 10 20 26 30 				biggest 10 /2 = 5	k6
9 10 15 20 26 30			biggest 6 / 2 = 3	k5
9 10 15 20 23 26 30			biggest 5 / 2 = 2	k4
9 10 12 15 17 20 23 26 30		biggest 5 / 2 = 2       k3
9 10 12 15 17 20 23 26 28 30		biggest 4 / 2 = 2	k2
9 10 12 13 15 17 20 23 26 28 30		biggest 3 / 1 = 1 	k1
					if k1
						done;	

					biggest 3 / 2 = 1	k2
10 13 15 16 17				biggest 2 / 2 = 1	k1
10 11 13 15 16 17			
10 11 12 13 15 16 17

					biggest 3 / 2 = 1	k3
1 2 3 4 5 6 7 10			biggest 2 / 2 = 1	k2
1 2 3 4 5 6 7 8 10			biggest 1 / 2 = 0.5	k1
1 2 3 4 5 6 7 8 9 10			if kx == 0.xx
						return count max diff;	

update arr
[25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
[25, 14, x,  56, 15, 36, 56, 77, 18, 29, 49]
 1   2   3   4    5   6   7   8   9  10  11
				