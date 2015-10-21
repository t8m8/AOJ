#include <iostream>
#include <limits>
#include <cmath>

using namespace std;

int main() {

	int v;
	while (cin >> v) {
		int sum = 0;
		for(unsigned i = 0; i < 10; ++i) {
			if ((v>>i)&1) {
				sum += pow(2,i);
				cout << pow(2,i);
				if (sum != v) cout << " ";
			}
		}
		cout << endl;
	}

	return 0;
}