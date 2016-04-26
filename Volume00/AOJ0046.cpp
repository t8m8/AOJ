#include <iostream>
#include <limits>
#include <cmath>

using namespace std;

int main() {

	double v;
	double max_v = -1, min_v = numeric_limits<int>::max();
	while (cin >> v) {
		max_v = max(max_v, v);
		min_v = min(min_v, v);
	}

	cout << (max_v - min_v) << endl;

	return 0;
}