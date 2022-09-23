#include <iostream>
#include <bitset>
#include <vector>
#include <string>
#include <windows.h>
#include <future>
using namespace std;

class Receiver;
class Sender;

class Receiver {
    private:
        string data;
        vector<string> packets;
        vector<string> frames;

        void NetworkLayer() {
            
        }
        void DataLinkLayer() {

        }
        int PhysicalLayer(string frame) {
            //Check if any frames are received yet
            if (!frames.empty()) {
                //If true, move forward
                string lastFrame = frames.back();
                char checkBit = lastFrame[lastFrame.length() - 1];

                if ()
            }
        }
    public:
        Receiver() {
            //Create sample data
            data = bitset<32>(502).to_string();
        }
        int ProcessData(string frame) {
            int response = PhysicalLayer(frame);
            return response;
        }
};

class Sender {
    private:
        string data;
        vector<string> packets;
        vector<string> frames;

        void NetworkLayer() {
            cout << data << endl;
            int pcktSize = 8;
            for (int i = 0; i < data.length(); i+=8) {
                //Iterating over every 8 bits of data
                string packet = "";
                for (int j = 0; j < pcktSize; j++) {
                    packet += data[i+j];
                }
                //Debugging
                //cout << packet << " ";
                //Encode packets using some error checking mechanism first

                //Append packet to the packets array
                packets.push_back(packet);
            }
            //Debugging
            //cout << endl;
        }
        void DataLinkLayer() {
            int frameSize = 5;
            for (int i = 0; i < packets.size(); i++) {
                string packet = packets.at(i);

                bool flag = true;
                for (int j = 0; j < packet.length(); j+= (frameSize - 1)) {
                    string frame = "";
                    for (int k = 0; k < frameSize - 1; k++) {
                        frame += packet[j+k];
                    }
                    //Append last bit to each frame
                    if (flag) frame += "0";
                    else frame += "1";
                    //Debugging
                    //cout << frame << " ";

                    frames.push_back(frame);

                    //Invert the flag
                    flag = !flag;
                }
            }
            //Debugging
            //cout << endl;
        }
        void PhysicalLayer(string frame) {
            int timeout = 3000; //In milliseconds
            //Wait for response or until timeout
            future<bool> ft = async(checkTimeout, timeout);

        }
        bool checkTimeout(int time) {
            Sleep(time);
            return false;
        }
    public:
        Sender() {
            //Create sample data
            data = bitset<32>(502505).to_string();

            NetworkLayer();
            DataLinkLayer();
        }
        void sendData(Receiver r) {
            int frameCount = 0, response=0;
            while (true) {
                if (response == 0) {

                }


            }
            cout << "\nData Transmission successfull\n"; 
        }
};



int main() {
    Sender s;
}