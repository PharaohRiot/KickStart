Google Kick Start Round E: Toys
https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff47/00000000003bede9

![excel screen](<algo.jpg>)

![excel screen](<algo2.jpg>)

1
1
5 1
	SUM	SLEEP	REMOVE	counter
run 1.	5	1	0	1
run 2.  cry

1
2
5 6		
10 3
	SUM	SLEEP	REMOVE	counter
run 1.	5	10	0	1
run 2.	15	3	0	
run 3.	20	10	0	2
run 4.	30	3	0	

if (counter for infinity > 2)
	sout removed + infinity

logic
(j) - (i + 1)  
(10 - 10) >= 0
	allow
	--> if next toy 
		go next toy
	    else 
		start with first toy
		
boolean readyToGoA = false;
int sleepLogicOfA = j0;
int sleepLogicOfB = j1;
boolean readyToGoB = false;

while(every run ... true){

if((sleepLogicOfA - Ei minutes) <= 0){
	readyToGoA = true; // is ready for next run
else
	sleepLogicOfAi = sleep logic a - Ei minutes;
	readyToGoA = false;
}

// if(this true no need to minus Ei minutes)
if((sleepLogicOfB - Ei minutes) <= 0){
	readyToGoB = true;
else
	sleepLogicOfB = sleepLogicOfB - Ei minutes;
	readyToGoB = false;
}

counter++;

if(counter > 5)
	sout infinity;

if(readyToGoA == false && readyToGoB == false){
	sout SUM;
	break;
}
}

1
3
30 17
5 10
10 3
	SUM	SLEEP	REMOVE	counter
run 1.	30	17	0	1
run 2.	35	10	0	1
run 3.	45	3	0	1

logic
(j) - (i1) 
17 - 5 = 12
(j1) - (i2) 
10 - 10 = 0
(j2) - (i)  
3 - 30 = -27	remove   --> jump to check infinity logic

1
2
5 10
10 3
		SLEEP
	SUM	10f - 5 = 5y			REMOVE	counter
run 1.	5	5y - 5 = 0y	10f - 5 = 5f	
run 2.	10	5f - 5 = 0f 	
run 3.	15	11 - 
run 4.	20	

3	1.loop										2.loop
30 17	hra sa s 1. 30min moze sa hrat s 2. (1. zabuda 17min)					
5 10	hra sa s 2. 35min moze sa hrat s 3. (1. zabuda za 12min | 2. zabuda 10min)	hra sa s 2. 50min moze sa hrat s 1. a 3. (2. zabuda za 10min )
10 3	hra sa s 3. 45min moze sa hrat s 2. (1. zabuda za 2min | 3. zabuda za 3min)			

3	1.loop									2.loop
5 10	hra sa 5 zabuda 10							hra sa 20 moze sa hrat s 2. (1. zabuda 10min | 3. zabuda 6min)
5 10	hra sa 10 (1. zabuda 5min | 2. zabuda 10min)				hra sa 25 moze sa hrat s 3. (1. zabuda 5min | 3. zabuda 1min)
5 11	hra sa 15 moze sa hrat s 1. (2. zabuda 5min | 3. zabuda 11)		place	--> hral sa max 25min