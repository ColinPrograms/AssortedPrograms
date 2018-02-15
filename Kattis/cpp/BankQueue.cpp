#include <iostream>
#include <vector>
#include <cstdlib>

int main(){
	int queueLength, close;
	using namespace std;
	cin >> queueLength;
	cin >> close;
	vector<pair<int,int> > queue;
	queue.reserve(10000);

	for(int k=0;k<queueLength;k++){
		int cash,waitTime;
		bool check = false;
		cin >> cash;
		cin >> waitTime;
		pair<int,int> currentCust = make_pair(cash,waitTime);
		for(int j=0;j<queue.size();j++){
			if(currentCust.first > queue[j].first){
				queue.insert(queue.begin() + j,currentCust);
				check = true;
				break;
			}
			if(currentCust.first == queue[j].first){
				if(currentCust.second >= queue[j].second){
					queue.insert(queue.begin() + j,currentCust);
					check = true;
					break;
				}
			}
		}
		if(!check){
			queue.insert(queue.begin() + queue.size(), currentCust);
		}
	}
	string toServe[close];
	int count = 0;
	int time = close;
	int blah=0;
	for(int j=0;j<time;j++){
		bool check2 = false;
		if(queue[j].second > close-1){
			blah = close-1;
		}else{
			blah = queue[j].second;
		}
		for(int i = blah;i>=0;i--){
			if(toServe[i] == ""){
				string toInsert = to_string(queue[j].first);
				toServe[i] = toInsert;
				check2 = true;
				break;
			}
		}
		count++;
		if(!check2 && count <= queueLength){
			time++;
		}
	}
	int total = 0;
	for(int j=0;j<close;j++){
		int apple = atoi(toServe[j].c_str());
		//cout << apple << "\n";
		total+= apple;
	}
	cout << total;
	return 0;
}