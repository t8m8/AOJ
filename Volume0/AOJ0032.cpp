#include <iostream>
#include <limits>
#include <cmath>
#include <sstream>

using namespace std;

int main() {

	int a,b,c,p = 0,l = 0;
	while (scanf("%d,%d,%d",&a,&b,&c) != EOF) {
		if (a*a + b*b == c*c) p++;
		if (a == b) l++;
	}

	cout << p << endl << l << endl;

	return 0;
}