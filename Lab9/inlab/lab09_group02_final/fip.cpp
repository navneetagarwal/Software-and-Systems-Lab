#include <iostream>
#include <ctime>
using namespace std;

	const clock_t begin_time = clock();	
// domain: x >= 0
int fibonacci (int x) {
	if (x <= 1) return x;
	return fibonacci(x-1) + fibonacci(x-2);
	/* (later) think about making this tail recursive */
}

int main (int argc, char* argv[]) {

	if (argc < 2)
		return 1;

	int n = atoi(argv[1]);

	cout <<argv[1]<<", "<<fibonacci(n)<<", ";
	cout <<float( clock () - begin_time )/  CLOCKS_PER_SEC<<endl;

	return 0;

}