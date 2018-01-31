#include <iostream>
#include <vector>

int main(){
	int testcases = 0;
	int numberofPhones = 0;

	std::cin >> testcases;

	for(int k = 0; k < testcases; k++){
		std::cin >> numberofPhones;
		std::vector<std::string> testcase;
		testcase.reserve(10000);
		std::string consistent = "YES";

		for(int j = 0; j < numberofPhones; j++){
			
			std::string phone;
			std::cin >> phone;
			testcase.push_back(phone);
			
			for(int i = 0; i < testcase.size()-1; i++){
				std::string compare;
				std::string resize;
				bool check = true;
				compare = testcase[i];
				if (compare.length() > phone.length()){
					compare.resize(phone.length());
					resize = compare;
					check = false;
				}
				else{
					resize = phone;
					resize.resize(compare.length());
				}
				if(check){
					if(resize == compare){
						consistent = "NO";
						break;
					}
				}else{
					if(resize == phone){
						consistent = "NO";
						break;
					}
				}
			}
			if(consistent == "NO"){
				for(;j<numberofPhones-1;j++){
					std::cin >> phone;
				}
				break;
			}
		
		}
		std::cout << consistent << "\n";
		testcase.clear();
	}
	return 0;
}