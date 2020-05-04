**Home Properties Control - Back-end Application**
---
It is a simple application which provides REST API for Android Application, and Sensors.

The idea was to create a simple system which allows to control connected devices 
(eg. power lines, lights, tv, stereo etc.) 
over local and global network (high level security required).
---
This application is a back-end application intended to run on server (RaspberryPi), which:
-
- has access to appliances directly (RPi I/O), 
- provides REST API for appliances which cannot be connected directly,
- provides REST API for Android Application (User Interfece),
- provides simple web front-end for basic administration (add/delete properties),
- can be easily extended by another features: play radio station.  

---
Application models:
-
- Sensors,
- Users,
- Complains - for bugs reports,
- Motd - Message Of The Day - simple message sent to user.