## PC Requirements
OSX & Linux:
    1.Gstreamer 1.0 with H264 decoder (h264parse, avdec_h264)
    2.FFplay is required. input 'ffplay' in terminal to check.
    3.adb for mirror via USB. input 'adb' to check.'

Windows:
    Not supported yet.

## Build and Install

1. You need to download the ”Linkedcall” and “Linkedshare” in the “Dependency” document and build both of them,                 installing them in the emulator or android phone. 

2. Download the whole main package to build and  install as first step.
        
## Register and Login
(Both MongoDB and SQLite database provided. For MongoDB, you also need to download node.js, mogoDB package and Robomongo)
        Register and Login:(Both MongoDB and SQLite database provided. For MongoDB, you also need to download node.js, mogoDB package and Robomongo)

Click 'Linkedout' to run main application.
- If you have registered for Linkedout before, type in user name and passwords to login.
- If this is your first time launching Linkedout, click REGISTER to create a new account.

After sign in the application, there are two main functions you can use.
        1. If you want to caputure your android screen and save as .mp4 video on your local storage, click the button after "Click to Start". The application would request for user permissions and would start screen capturing and minimalize the application automatically.
        2. If you want to share your screen to PC end and make free video call via internet, click "SHARING ONLINE" to initial screen sharing intent.

## Share Screen
You have to open your wifi and put your phone and a PC receiver in the same WLAN. (Commercial Wlan is forbidden due to security issue).
When the PC end is ready, an available IP address would showed in available list. Click to choose one IP in the list, then click "START" on the top right of the screen to start screen sharing. The screen sharing would start after you give permissions to the application.
Click "STOP" whenever you want to stop the screen sharing session.

## Video Chat
We integrated a free call(WebRTC) into our application. In LikedSharing page, there is a "Call" button at the buttom of the screen. Click the "Call" button to start LinkedCall intent. 
In LinkedCall page, input a service ID (a room ID, actually) then click dialog icon after the input window to start video call. In PC end, to start a video call session or join an existed session, using Chrome or Firefox browser goto www.appr.tc input a random number or an existed service number to start video call. To stop, quit the application or click hangout icon.                      Notice, when you minimalize LinkedCall page, the video call would pause but audio still works, the PC end can still hear you in order to help you with phone issues.

On PC:
        To initial PC end, open terminal, go to receiver folder, execute the following lines:
        $ python cs_receiver.py
        NOTICE: we only support python 2.7.

When the android device connects successfully, an FFplay window would open to play the screen capture video.











