package com.mycode.interview;

/*Welcome to Facebook!

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you would like to use for your interview,
simply choose it from the dropdown in the top bar.

Enjoy your interview!

Famous Person

1 | 7,4,9
7 | 4
4 | ---
9 | 4,7 

To Be Famous:

1) You know no one
2) Everyone else knows you


input a: int
input b: int
knows(a, b) ==> true iff "a" knows "b"
knows(1,7) ==> true
knows(7,1) ==> false

FamousPerson function:
input : Set<int>
output: int (-1 if no famous)

*/

class FamousPerson {
public static void main(String[] args) {
	int p[] = {1,7,4,9};
	getFamousPerson(p);
}

static int getFamousPerson(int p[]){
  
    int r[][] = new int [p.length][p.length];
    for (int i = 0; i<r.length; i++){
      for(int j = 0; j < r.length; j++){
        if(r[i][j] == knows(p[i],p[j])){
            r[i][j] = 1;
        }else{
            r[i][j] = 0;
      }
    }
   }
    int noFamous = -1;
    for (int i = 0; i<r.length; i++){
      for(int j = 0; j < r.length; j++){
        if(r[i][j] == 0){
          return 1;
        }
      }
    }
  return noFamous;
  //Traverse again and check for all 1
}

private static int knows(int i, int j) {
	// TODO Auto-generated method stub
	return 0;
}
}

//F =0
//T =1  
//  1  4  7  9
//1 F  T  T  T
//4 F  F  F  F
//7    T  
//9    T  T  




