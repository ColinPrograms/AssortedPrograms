#include <iostream>
int main(){
	std::string jon;
	std::string doctor;
	std::cin >> jon;
	std::cin >> doctor;

	if (jon.size()>=doctor.size()){
		std::cout << "go";
	}else{
		std::cout << "no";
	}

	return 0;
}