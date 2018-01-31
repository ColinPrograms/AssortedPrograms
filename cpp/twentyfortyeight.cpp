#include <iostream>
#include <cstring>

int playArea[4][4];
void shift();
void rotateLeft();
using namespace std;

int main(){


	int direction;

	for(int j = 0;j<4;j++){
		cin >> playArea[j][0];
		cin >> playArea[j][1];
		cin >> playArea[j][2];
		cin >> playArea[j][3];
	}
	cin >> direction;

	switch(direction){
		case 0 :
		shift();
		break;
		case 1 :
		rotateLeft();
		shift();
		rotateLeft();
		rotateLeft();
		rotateLeft();
		break;
		case 2 :
		rotateLeft();
		rotateLeft();
		shift();
		rotateLeft();
		rotateLeft();
		break;
		case 3 :
		rotateLeft();
		rotateLeft();
		rotateLeft();
		shift();
		rotateLeft();
		break;
	}
	for(int k=0;k<4;k++){
		for(int j=0;j<4;j++){
		cout << playArea[k][j] << " ";
		}
		cout << "\n";
	}
	return 0;
}

void shift(){
	for(int k=0;k<4;k++){
	int zeroes = 0;
	int p = 3;
	for(int j=0;j<p;j++){
		if(playArea[k][j]==0){
			zeroes++;
			for(int i=j;i<3;i++){
				playArea[k][i] = playArea[k][i+1];

			}
			j--;
			p--;
		}
	}
	for(int j=3;j>=4-zeroes;j--){
		playArea[k][j] = 0;
	}
	int cur = 0;
	for (int i = 0; i < 4-zeroes; i++){
		if(i != 3){
			if(playArea[k][i] == playArea[k][i+1]){
				playArea[k][cur] = 2*playArea[k][i];
				playArea[k][i+1] = 0;
				cur++;
				i++;
			}else{
				playArea[k][cur] = playArea[k][i];
				cur++;
			}
		}else{
			playArea[k][cur] = playArea[k][i];
			cur++;
		}
	}
	for (int i = cur; i < 4; i++){
		playArea[k][i] = 0;
	}
	}	
}

void rotateLeft(){
	int blah[4][4];
	for (int k = 0; k < 4; k++)
	{
		for (int i = 0; i < 4; i++)
		{
			blah[k][i] = playArea[i][3-k];

		}
	}

	memcpy(playArea,blah,sizeof(playArea));
}